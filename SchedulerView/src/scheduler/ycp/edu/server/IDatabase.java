package scheduler.ycp.edu.server;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import scheduler.ycp.edu.shared.Course;


public interface IDatabase {
	public ArrayList<Course> findCourse(String courseName) throws SQLException;

	ArrayList<Course> getSchedule(int scheduleID) throws SQLException;

	//Map<String, ArrayList<Course>> getDatabase();
}
