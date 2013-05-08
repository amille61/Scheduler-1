package scheduler.ycp.edu.client;

import java.util.ArrayList;

import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("generate")
public interface GenerateService extends RemoteService{

	public Boolean hello(String message);

	Boolean generateSchedule(Schedule schedule);

}
