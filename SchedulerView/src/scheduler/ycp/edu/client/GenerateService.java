package scheduler.ycp.edu.client;

import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("generate")
public interface GenerateService extends RemoteService{

	public Boolean hello(String message);
	
	public Boolean generateSchedule(Schedule schedule);
	
	public Boolean pullDatabase();
}
