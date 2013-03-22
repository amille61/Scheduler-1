package scheduler.ycp.edu.shared;

import java.util.ArrayList;
import java.util.List;

public class ScheduleListController {
	public List <String> getRequired(Schedule schedule){
		List <String> requiredList = new ArrayList<String>();
		String course;
		
		for(int i = 0; i < schedule.getRequiredList().size(); i++){
			course = schedule.getRequiredList().get(i);
			requiredList.add(course);
		}
		
		return requiredList;
		
	}
}
