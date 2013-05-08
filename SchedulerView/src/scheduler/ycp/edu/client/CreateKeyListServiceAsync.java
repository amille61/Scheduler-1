package scheduler.ycp.edu.client;

import java.util.ArrayList;
import java.util.Collection;

import scheduler.ycp.edu.shared.Course;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateKeyListServiceAsync {

	void pullDatabase(String courseName, AsyncCallback<ArrayList<Course>> callback);
	
	void pullKeyList(AsyncCallback<ArrayList<String>> callback);
}
