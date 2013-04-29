package scheduler.ycp.edu.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import scheduler.ycp.edu.server.DBUtil;
import scheduler.ycp.edu.server.ITransaction;

public class DerbyDatabase implements IDatabase {

private static final String DATASTORE = "H:/courses";
	
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new RuntimeException("Could not load Derby JDBC driver");
		}
	}
	
	private class DatabaseConnection {
		public Connection conn;
		public int refCount;
	}
	
	private final ThreadLocal<DatabaseConnection> connHolder = new ThreadLocal<DatabaseConnection>();
	
	private DatabaseConnection getConnection() throws SQLException {
		DatabaseConnection dbConn = connHolder.get();
		if (dbConn == null) {
			dbConn = new DatabaseConnection();
			dbConn.conn = DriverManager.getConnection("jdbc:derby:" + DATASTORE + ";create=true");
			dbConn.refCount = 0;
			connHolder.set(dbConn);
		}
		dbConn.refCount++;
		return dbConn;
	}
	
	private void releaseConnection(DatabaseConnection dbConn) throws SQLException {
		dbConn.refCount--;
		if (dbConn.refCount == 0) {
			try {
				dbConn.conn.close();
			} finally {
				connHolder.set(null);
			}
		}
	}
	
	private<E> E databaseRun(ITransaction<E> transaction) throws SQLException {
		// FIXME: retry if transaction times out due to deadlock
		
		DatabaseConnection dbConn = getConnection();
		
		try {
			boolean origAutoCommit = dbConn.conn.getAutoCommit();
			try {
				dbConn.conn.setAutoCommit(false);

				E result = transaction.run(dbConn.conn);
				dbConn.conn.commit();
				return result;
			} finally {
				dbConn.conn.setAutoCommit(origAutoCommit);
			}
		} finally {
			releaseConnection(dbConn);
		}
	}
	
	void createTables() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {
				
				PreparedStatement stmt = null;
				
				try {
					stmt = conn.prepareStatement(
							/*"create table order_receipts (" +
							"  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"  userinfo VARCHAR(200) NOT NULL, " +
							"  price DECIMAL(10,2) " +
							")"*/
							"create table courses (" +
							"num, " +
							"CRNNum, " +
							"name, " +
							"credit, " +
							"days, " +
							"startTime, " +
							"endTime, " +
							"instructor, " +
							"room " +
							")"
					);
					
					stmt.executeUpdate();
				} finally {
					DBUtil.closeQuietly(stmt);
				}
				
				return true;
			}
		});
	}
		
	
	@Override
	public List<Course> findCourse(String courseName) throws SQLException {
		return databaseRun(new ITransaction<List<Course>>() {
			@Override
			public List<Course> run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement("select * from courses");
					resultSet = stmt.executeQuery();
					
					List<Course> result = new ArrayList<Course>();
					
					while (resultSet.next()) {
						Course course = new Course(null, 0, null, 0, null, 0, 0, null, null);
						
						course.setNum(resultSet.getString(0));
						course.setCRNNum(resultSet.getInt(1));
						course.setName(resultSet.getString(2));
						course.setCredit(resultSet.getInt(3));
						course.setDays(resultSet.getString(4));
						course.setStartTime(resultSet.getInt(5));
						course.setEndTime(resultSet.getInt(6));
						course.setInstructor(resultSet.getString(7));
						course.setRoom(resultSet.getString(8));
						
						result.add(course);
					}
					
					
					return result;
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
		
	}

	@Override
	public Map<String, List<Course>> getDatabase() {
		// put the courses into a table
		return null;
	}

}
