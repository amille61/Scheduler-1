package scheduler.ycp.edu.shared;

import java.io.Serializable;


public class Course implements Serializable {
	private String num;
	private int CRNNum;
	private String name;
	private int credit;
	private String days;
	private double startTime;
	private double endTime;
	private String instructor;
	private String room;
	
	public Course() {
		
	}
	
	public Course(String num2, int CRNNum2, String name2, int credit2, String days2, double startTime2, double endTime2, String instructor2, String room2) {
		setNum(num2);
		setCRNNum(CRNNum2);
		setName(name2);
		setCredit(credit2);
		setDays(days2);
		setStartTime(startTime2);
		setEndTime(endTime2);
		setInstructor(instructor2);
		setRoom(room2);		
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getCRNNum() {
		return CRNNum;
	}
	public void setCRNNum(int cRNNum) {
		CRNNum = cRNNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public double getStartTime() {
		return startTime;
	}
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	public double getEndTime() {
		return endTime;
	}
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}

}




