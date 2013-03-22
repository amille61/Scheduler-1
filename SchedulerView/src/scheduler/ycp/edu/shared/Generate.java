package scheduler.ycp.edu.shared;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Generate extends Publisher implements ISubscriber, Serializable{
	
	private Schedule schedule;
	private List <String> requiredList;
	
	public Generate(){
		
		
	}
	
	public void setSchedule(Schedule schedule){
		this.schedule = schedule;
		schedule.subscribe(Schedule.Events.ADD_REQUIRED, this);
		schedule.subscribe(Schedule.Events.REMOVE_REQUIRED, this);
	}
	
	public Schedule getSchedule(){
		return schedule;
	}
	
	public void setRequiredList(List <String> requiredList){
		this.requiredList = requiredList;
	}
	
	public List <String> getRequiredList(){
		return requiredList;
	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
		ScheduleListController controller = new ScheduleListController();
		setRequiredList(controller.getRequired(schedule));
		
	}

}
