package scheduler.ycp.edu.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.impl.SchedulerImpl;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;

import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.Generate;
import scheduler.ycp.edu.shared.GenerateInit;
import scheduler.ycp.edu.shared.IPublisher;
import scheduler.ycp.edu.shared.ISubscriber;
import scheduler.ycp.edu.shared.Schedule;
import com.google.gwt.user.cellview.client.DataGrid;

public class GenerateView extends Composite implements ISubscriber{
	
	private Schedule model;
	//private SchedulerViewView schedulerViewView;
	private ArrayList<Course> requiredCourseList = new ArrayList<Course>();
	private ArrayList<Course> optionalCourseList = new ArrayList<Course>();
	private static List<Course> scheduleM = new ArrayList<Course>();
	private static List<Course> scheduleT = new ArrayList<Course>();
	private static List<Course> scheduleW = new ArrayList<Course>();
	private static List<Course> scheduleR = new ArrayList<Course>();
	private static List<Course> scheduleF = new ArrayList<Course>();
	private SchedulerViewView schedulerView;

	public GenerateView() {
		FlowPanel panel = new FlowPanel();
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("687px", "479px");
		
		schedulerView = new SchedulerViewView();
		this.schedulerView = new SchedulerViewView();
		panel.add(schedulerView);
//		model = new Schedule();
		
		schedulerView.setModel(model);
		schedulerView.update();
//		Schedule model = new Schedule();
//		
//		schedulerView.setModel(model);
//		schedulerView.update();
	
		Button generateButton = new Button("Generate");
		generateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String courseName;
				if(!model.getRequiredList().isEmpty()){
					for(int i =0; i < model.getRequiredList().size(); i++){
							courseName = model.getRequiredList().get(i);
							handleGetDatabase(courseName);	//generate
					}
				}
			}
		});
		panel.add(generateButton);
		
		initWidget(panel);
	}
	
	public void setModel(Schedule model){
		this.model = model;
		schedulerView.setModel(model);
	}

	protected void handleGenerate() {
//		RPC.generateService.generateSchedule(model, new AsyncCallback<Boolean>(){
//
//			@Override
//			public void onFailure(Throwable caught) {
//				GWT.log("Fail!", caught);
//				
//			}
//
//			@Override
//			public void onSuccess(Boolean result) {
				GenerateInit generate = new GenerateInit();
				generate.setRequiredList(model.getRequiredList());
				for(int i = 0; i < generate.getRequiredList().size(); i++){
					GWT.log(generate.getRequiredList().get(i));
				}	
//			}
//			
//		});
			RPC.generateService.generateSchedule(model, new AsyncCallback<Boolean>(){
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Fail!", caught);
				
			}

			@Override
			public void onSuccess(Boolean result) {
				/*GenerateInit generate = new GenerateInit();
				generate.setRequiredList(model.getRequiredList());
				if(!generate.getRequiredList().isEmpty()){
					for(int i = 0; i < generate.getRequiredList().size(); i++){
						GWT.log(generate.getRequiredList().get(i));
					}	
				}*/ // output test
				String courseName;
				if(!model.getRequiredList().isEmpty()){
					for(int i =0; i < model.getRequiredList().size(); i++){
							courseName = model.getRequiredList().get(i);
							//handleGetDatabase(courseName);	//adds courses to non-model requiredCourseList
						/*	while(requiredCourseList.size() <= i){	// need a delay for handleGetDatabase but this while loop breaks it
							}*/
					}
				}
				Generate generate = new Generate();
				if(!requiredCourseList.isEmpty()){
					generate.GenerateSchedule(requiredCourseList, requiredCourseList);
					scheduleM = generate.getScheduleM();
					scheduleT = generate.getScheduleT();
					scheduleW = generate.getScheduleW();
					scheduleR = generate.getScheduleR();
					scheduleF = generate.getScheduleF();
					GWT.log("GENERATED");
				}
				GWT.log("Monday");
				if(!scheduleM.isEmpty()){
					for(int i = 0; i < scheduleM.size(); i ++){
						GWT.log(scheduleM.get(i).getNum() + "M");
					}
				}
				else{
					GWT.log("M is empty");
				}
				if(!scheduleF.isEmpty()){
					GWT.log(scheduleF.get(0).getNum());
				}
				else{
					GWT.log("F is empty");
				}
					
			}
			
		});
		
	}
	protected void handleGetDatabase(String courseName) {
		RPC.keyListService.pullDatabase(courseName, new AsyncCallback<ArrayList<Course>>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Fail!", caught);

			}

			@Override
			public void onSuccess(ArrayList<Course> result) {
				
				if(!requiredCourseList.contains(result)){
					GWT.log(result.get(0).getNum() + "SUCCESS");
					requiredCourseList.add(result.get(0));	//adds the first instance of the course [temporary]
				}
				
//				GWT.log("Element");
//				GWT.log(requiredCourseList.get(0).getNum());
				
				if (requiredCourseList.size() == model.getRequiredList().size() ) {
					GWT.log(model.getRequiredList().get(0) + "list");
					Generate generate = new Generate();
					if(!requiredCourseList.isEmpty()){
						generate.GenerateSchedule(requiredCourseList, optionalCourseList);
						scheduleM = generate.getScheduleM();
						scheduleT = generate.getScheduleT();
						scheduleW = generate.getScheduleW();
						scheduleR = generate.getScheduleR();
						scheduleF = generate.getScheduleF();
						GWT.log("GENERATED");
					}
					GWT.log("Monday");
					if(!scheduleM.isEmpty()){
						for(int i = 0; i < scheduleM.size(); i ++){
							GWT.log(scheduleM.get(i).getNum() + "M");
						}
					}
					else{
						GWT.log("M is empty");
					}
					if(!scheduleF.isEmpty()){
						GWT.log(scheduleF.get(0).getNum());
					}
					else{
						GWT.log("F is empty");
					}
				}
				
			}

		});

	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
		// TODO Auto-generated method stub
		
	}

}
