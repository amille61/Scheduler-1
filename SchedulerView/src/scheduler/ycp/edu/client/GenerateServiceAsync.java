package scheduler.ycp.edu.client;

import java.util.ArrayList;

import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GenerateServiceAsync {
	
	void hello(String message, AsyncCallback<Boolean> callback);

	void generateSchedule(Schedule model, AsyncCallback<Boolean> asyncCallback);

}
