package scheduler.ycp.edu.server;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import scheduler.ycp.edu.server.IDatabase;
import scheduler.ycp.edu.server.ListRead;


import scheduler.ycp.edu.shared.Course;

public class FakeDatabase implements IDatabase {
	private Map<String, ArrayList<Course>> coursesByName;
	private ListRead list;
	private List<Course> courseList;

	public void CreateFakeDatabase(File fileName) throws IOException {

		list = new ListRead(fileName);
		courseList = list.Read(); // load courses from CSV file into Array List

		coursesByName = new HashMap<String, ArrayList<Course>>();

		Course course = new Course(null, 0, null, 0, null, 0, 0, null, null);

		String prevCourseName = "";
		ArrayList<Course> tempList = new ArrayList<Course>();
		for (int i = 0; i < courseList.size(); i++) {
			course = courseList.get(i); // get next class
			if (i == 0) {
				prevCourseName = course.getNum(); // sets up the course name for the first run through
			}
			if ((course.getNum()).equals(prevCourseName)) { // checks if course is the same name but different section as last course

				tempList.add(course);
				if (i == courseList.size() - 1) { // makes sure the last course still gets saved even if it's the same
												  // course as the previous one

					coursesByName.put(prevCourseName, tempList);
				}
			} else {
				coursesByName.put(prevCourseName, tempList); // stores the list of previous courses
				tempList = new ArrayList<Course>();
				tempList.add(course); // add new course (with a different name) to the list
				if(i == courseList.size() - 1){		// stores the course if it is the final one
					coursesByName.put(course.getNum(), tempList);
				}
			}
			prevCourseName = course.getNum(); // change the name to the current course for comparison in the next loop cycle
		}

	}

	@Override
	public ArrayList<Course> findCourse(String courseName) {
		if (coursesByName.containsKey(courseName)) {
			return coursesByName.get(courseName);
		} else {
			return null;
		}
	}

	@Override
	public ArrayList<Course> getSchedule(int scheduleID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<String, ArrayList<Course>> getDatabase() {
		return coursesByName;
	}
}
