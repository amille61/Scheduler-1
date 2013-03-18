package scheduler.ycp.edu.server;

import scheduler.ycp.edu.client.GenerateService;
import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ScheduleServiceImpl extends RemoteServiceServlet implements GenerateService{

	@Override
	public Boolean hello(String message) {
		System.out.println("Hello: " + message);
		return true;
	}

	@Override
	public Boolean generateSchedule(Schedule schedule) {
		//System.out.println("generate called on server?");
		for(int i = 0; i < schedule.getRequiredList().size(); i++){
			System.out.println(schedule.getRequiredList().get(i).toString());
		}
		return true;
	}

}
