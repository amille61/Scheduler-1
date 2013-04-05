package scheduler.ycp.edu.server;

import java.sql.Connection;
import java.sql.SQLException;

public interface ITransaction<E> {
	public E run(Connection conn) throws SQLException;
}
