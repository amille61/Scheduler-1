package scheduler.ycp.edu.server;


import java.io.File;
import java.io.IOException;
import java.util.Collection;

import scheduler.ycp.edu.client.CreateKeyListService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class CreateDatabaseImpl extends RemoteServiceServlet implements CreateKeyListService{
	private FakeDatabase database;

	public Boolean pullDatabase(){
			File fileName = new File("Course_List.csv");
			try {
				database.CreateFakeDatabase(fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	
	public Collection<String> pullKeyList(){
		Collection<String> tempCourseList = database.getDatabase().keySet();
		
		return tempCourseList;
	}


}
