package scheduler.ycp.edu.shared;

import java.util.ArrayList;
import java.util.List;

public class ScheduleListController {
	public List <CourseType> getRequired(Schedule schedule){
		List <CourseType> requiredList = new ArrayList<CourseType>();
		CourseType course;
		
		for(int i = 0; i < schedule.getRequiredList().size(); i++){
			course = schedule.getRequiredList().get(i);
			requiredList.add(course);
		}
		
		return requiredList;
		
	}
}
