package scheduler.ycp.edu.client;

import java.util.ArrayList;

import scheduler.ycp.edu.shared.Course;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("keylist")
public interface CreateKeyListService extends RemoteService{
		
	public ArrayList<Course> pullDatabase(String courseName);
	public ArrayList<String> pullKeyList();
		
}
