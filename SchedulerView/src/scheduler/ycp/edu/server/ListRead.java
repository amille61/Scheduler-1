package scheduler.ycp.edu.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ListRead {

	File fileName;

	public ListRead(File Name) {
		fileName = Name;
	}

	public List<Course> Read() throws IOException {
		BufferedReader list = new BufferedReader(new FileReader(fileName));
		ArrayList<Course> courses = new ArrayList<Course>();
		String courseChoice = list.readLine();
		while (courseChoice != null) {
			Course course = new Course(null, 0, null, 0, null, 0, 0, null, null);
			StringTokenizer description = new StringTokenizer(courseChoice, ",");
			course.setNum(description.nextToken());
			course.setCRNNum(Integer.valueOf(description.nextToken()));
			course.setName(description.nextToken());
			course.setCredit(Integer.valueOf(description.nextToken()));
			course.setDays(description.nextToken());
			course.setStartTime(Double.parseDouble(description.nextToken()));
			course.setEndTime(Double.parseDouble(description.nextToken()));
			course.setInstructor(description.nextToken());
			course.setRoom(description.nextToken());
			courses.add(course);
			courseChoice = list.readLine();
		}
		list.close();
		return courses;
	}
}
