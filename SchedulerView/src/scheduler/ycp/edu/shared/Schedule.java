package scheduler.ycp.edu.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Schedule extends Publisher implements Serializable{
	public enum Events{
		ADD_REQUIRED,
		REMOVE_REQUIRED,
		ADD_OPTIONAL,
		REMOVE_OPTIONAL,
	}
	private List<CourseType> requiredList;
	private List<CourseType> optionalList;
	
	public Schedule(){
		this.requiredList = new ArrayList<CourseType>();
		this.optionalList = new ArrayList<CourseType>();
	}
	
	public void addRequired(CourseType course){
		if(!requiredList.contains(course)){
			requiredList.add(course);
			notifySubscribers(Events.ADD_REQUIRED, course);
		}
	}
	
	public void addOptional(CourseType course){
		if(!optionalList.contains(course)){
			optionalList.add(course);
			notifySubscribers(Events.ADD_OPTIONAL, course);
		}
	}
	
	public void removeRequired(CourseType course){
		if(requiredList.remove(course)){
			notifySubscribers(Events.REMOVE_REQUIRED, course);
		}
	}
	
	public void removeOptional(CourseType course){
		if(optionalList.remove(course)){
			notifySubscribers(Events.REMOVE_OPTIONAL, course);
		}
	}
	
	public List<CourseType> getRequiredList(){
		return requiredList;
	}
	
	public List<CourseType> getOptionalList(){
		return optionalList;
	}
}
