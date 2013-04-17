package scheduler.ycp.edu.client;

import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.user.client.rpc.RemoteService;

public interface GrabService  extends RemoteService{
	
	public Boolean hello(String message);
	
	public Boolean generateSchedule(Schedule schedule);
	
	public Boolean pullDatabase();
}
