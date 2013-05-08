package scheduler.ycp.edu.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;

@SuppressWarnings("serial")
public class Schedule extends Publisher implements Serializable{
	public enum Events{
		ADD_REQUIRED,
		REMOVE_REQUIRED,
		ADD_OPTIONAL,
		REMOVE_OPTIONAL,
	}
	private List<String> requiredList;
	private List<String> optionalList;
	GenerateInit generate = new GenerateInit();
	
	public Schedule(){
		this.requiredList = new ArrayList<String>();
		this.optionalList = new ArrayList<String>();
	}
	
	public void addRequired(String course){
		if(!requiredList.contains(course)){
			requiredList.add(course);
			notifySubscribers(Events.ADD_REQUIRED, course);
		}
	}
	
	public void addOptional(String course){
		if(!optionalList.contains(course)){
			optionalList.add(course);
			notifySubscribers(Events.ADD_OPTIONAL, course);
		}
	}
	
	public void removeRequired(String course){
		if(requiredList.remove(course)){
			notifySubscribers(Events.REMOVE_REQUIRED, course);
		}
	}
	
	public void removeOptional(String course){
		if(optionalList.remove(course)){
			notifySubscribers(Events.REMOVE_OPTIONAL, course);
		}
	}
	
	public List<String> getRequiredList(){
		return requiredList;
	}
	
	public List<String> getOptionalList(){
		return optionalList;
	}
}
