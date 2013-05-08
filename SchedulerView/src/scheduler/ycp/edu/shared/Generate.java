package scheduler.ycp.edu.shared;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


public class Generate { 
	private static List<Course> scheduleM = new ArrayList<Course>();
	private static List<Course> scheduleT = new ArrayList<Course>();
	private static List<Course> scheduleW = new ArrayList<Course>();
	private static List<Course> scheduleR = new ArrayList<Course>();
	private static List<Course> scheduleF = new ArrayList<Course>();
	private static boolean checkReqCon;	// if this is false then two required courses conflict and the user
										// will have to input a new schedule
	private List<String> track = new ArrayList<String>();
	private int numReq;
	
	boolean checkOpen = false;

	
	public void GenerateSchedule(List <Course> requiredCourses, List<Course> optionalCourses){
		checkReqCon = true;
		numReq = requiredCourses.size();
		Course course;
		checkOpen = false;
		List<Course> courseList = new ArrayList<Course>();
		courseList.addAll(requiredCourses);
		courseList.addAll(optionalCourses);
		int numCourses = courseList.size();
		
		for(int i = 0; i < numCourses; i++){		// cycles through each course to add to the appropriate list
			track.clear();	//clears the tracker for each course
			
			course = courseList.get(i);
			
			
			// separates classes by the day of the week they are in
			// classes can be in multiple days

			if(course.getDays() == "M" || course.getDays() == "MW" || course.getDays() == "MWF"){	// using == since .contains isn't working
				checkOpen = checkScheduleM(course);
				if(checkOpen){
					scheduleM.add(course);	
					track.add("M");
				}
				else{
					removeCourse(i);
					if(checkReqCon = false){	// if two required courses conflict, break
						break;
					}
				}
			}
			if(course.getDays() == "T" || course.getDays() == "TR"){
				checkOpen = checkScheduleT(course);
				if(checkOpen){
					scheduleT.add(course);
					track.add("T");
				}	
				else{
					removeCourse(i);
					if(checkReqCon = false){
						break;
					}
				}
			}
			if(course.getDays() == "W" || course.getDays() == "WF" || course.getDays() == "MW" || course.getDays() == "MWF"){
				checkOpen = checkScheduleW(course);
				if(checkOpen){
					scheduleW.add(course);
					track.add("W");
				}
				else{
					removeCourse(i);
					if(checkReqCon = false){
						break;
					}
				}
			}
			if(course.getDays() == "R" || course.getDays() == "TR"){
				checkOpen = checkScheduleR(course);
				if(checkOpen){
					scheduleR.add(course);
					track.add("R");
				}
				else{
					removeCourse(i);
					if(checkReqCon = false){
						break;
					}
				}
			}
			if(course.getDays() == "F" || course.getDays() == "WF" || course.getDays() == "MWF"){
				checkOpen = checkScheduleF(course);
				if(checkOpen){
					scheduleF.add(course);
					track.add("F");
				}
				else{
					removeCourse(i);
					if(checkReqCon = false){
						break;
					}
				}
			}
		}
		
	}
	public List<Course> getScheduleM(){
	//	GenerateSchedule();
		return scheduleM;
	}
	public List<Course> getScheduleT(){
		//GenerateSchedule();
		return scheduleT;
	}
	public List<Course> getScheduleW(){
		//GenerateSchedule();
		return scheduleW;
	}
	public List<Course> getScheduleR(){
		//GenerateSchedule();
		return scheduleR;
	}
	public List<Course> getScheduleF(){
		//GenerateSchedule();
		return scheduleF;
	}
	
	public boolean checkScheduleM(Course course){
		for(int j = 0; j < scheduleM.size(); j ++){
			if(course.getStartTime() >= scheduleM.get(j).getStartTime() && course.getStartTime() <= scheduleM.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleM.get(j).getStartTime() && course.getEndTime() <= scheduleM.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		if(scheduleM.size() == 0){	// List is empty so no time conflicts, for loop doesn't run in list is empty
			checkOpen = true;
		}
		return checkOpen;
	}
	
	public boolean checkScheduleT(Course course){
		for(int j = 0; j < scheduleT.size(); j ++){
			if(course.getStartTime() >= scheduleT.get(j).getStartTime() && course.getStartTime() <= scheduleT.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleT.get(j).getStartTime() && course.getEndTime() <= scheduleT.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		if(scheduleT.size() == 0){
			checkOpen = true;
		}
		return checkOpen;
	}
	
	public boolean checkScheduleW(Course course){
		for(int j = 0; j < scheduleW.size(); j ++){
			if(course.getStartTime() >= scheduleW.get(j).getStartTime() && course.getStartTime() <= scheduleW.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleW.get(j).getStartTime() && course.getEndTime() <= scheduleW.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		if(scheduleW.size() == 0){
			checkOpen = true;
		}
		return checkOpen;
	}
	
	public boolean checkScheduleR(Course course){
		for(int j = 0; j < scheduleR.size(); j ++){
			if(course.getStartTime() >= scheduleR.get(j).getStartTime() && course.getStartTime() <= scheduleR.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleR.get(j).getStartTime() && course.getEndTime() <= scheduleR.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		if(scheduleR.size() == 0){
			checkOpen = true;
		}
		return checkOpen;
	}
	
	public boolean checkScheduleF(Course course){
		for(int j = 0; j < scheduleF.size(); j ++){
			if(course.getStartTime() >= scheduleF.get(j).getStartTime() && course.getStartTime() <= scheduleF.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleF.get(j).getStartTime() && course.getEndTime() <= scheduleF.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		if(scheduleF.size() == 0){
			checkOpen = true;
		}
		return checkOpen;
	}
	
	public void removeCourse(int courseNum){		// removes a course from any other schedule it may have been added to before the time conflict
		for(int i = 0; i < track.size(); i++){
			if(track.get(i) == "M"){
				scheduleM.remove(scheduleM.size() -1);
			}
			if(track.get(i) == "T"){
				scheduleT.remove(scheduleT.size() -1);
			}
			if(track.get(i) == "W"){
				scheduleW.remove(scheduleW.size() -1);
			}
			if(track.get(i) == "R"){
				scheduleR.remove(scheduleR.size() - 1);
			}
			if(track.get(i) == "F"){
				scheduleF.remove(scheduleF.size() -1);
			}
		}
		if(courseNum < numReq){
			checkReqCon = false;
		}
		
	}
	
}

