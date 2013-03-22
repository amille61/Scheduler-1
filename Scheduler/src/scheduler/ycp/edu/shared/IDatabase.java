package scheduler.ycp.edu.shared;


import java.util.List;
import java.util.Map;

public interface IDatabase {
	public List<Course> findCourse(String courseName);

	Map<String, List<Course>> getDatabase();
}
