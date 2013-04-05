package scheduler.ycp.edu.shared;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IDatabase {
	public List<Course> findCourse(String courseName) throws SQLException;

	Map<String, List<Course>> getDatabase();
}
