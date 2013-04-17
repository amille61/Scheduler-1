package scheduler.ycp.edu.client;

import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("grab")
public interface GrabServiceAsync{
	
	void hello(String message, AsyncCallback<Boolean> callback);

	void generateSchedule(Schedule schedule, AsyncCallback<Boolean> callback);
	
	void pullDatabase(AsyncCallback<Boolean> callback);

}
