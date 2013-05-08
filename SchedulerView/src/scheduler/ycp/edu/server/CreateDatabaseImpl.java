package scheduler.ycp.edu.server;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import scheduler.ycp.edu.client.CreateKeyListService;
import scheduler.ycp.edu.shared.Course;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class CreateDatabaseImpl extends RemoteServiceServlet implements CreateKeyListService{
	//private FakeDatabase database;
	FakeDatabase database = new FakeDatabase();
	public ArrayList<Course> pullDatabase(String courseName){
			ArrayList<Course> course = (ArrayList<Course>) database.findCourse(courseName);
			return course;
	}
	
	public ArrayList<String> pullKeyList(){
		File fileName = new File("Course_List.csv");
		//FakeDatabase database = new FakeDatabase();
		try {
			database.CreateFakeDatabase(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Collection<String> tempCourseList = database.getDatabase().keySet();
		
		ArrayList<String> result = new ArrayList<>();
		result.addAll(database.getDatabase().keySet());
		
		return result;
	}


}
