package scheduler.ycp.edu.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import scheduler.ycp.edu.shared.Generate;
import scheduler.ycp.edu.shared.IPublisher;
import scheduler.ycp.edu.shared.ISubscriber;
import scheduler.ycp.edu.shared.Schedule;

public class GenerateView extends Composite implements ISubscriber{
	
	private Schedule model;
	private SchedulerViewView schedulerView;

	public GenerateView() {
		FlowPanel panel = new FlowPanel();
		
		schedulerView = new SchedulerViewView();
		panel.add(schedulerView);
		model = new Schedule();
		
		schedulerView.setModel(model);
		schedulerView.update();
	
		Button generateButton = new Button("Generate");
		generateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handleGenerate();
			}
		});
		panel.add(generateButton);
		
		initWidget(panel);
	}

	protected void handleGenerate() {
		RPC.generateService.generateSchedule(model, new AsyncCallback<Boolean>(){

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Fail!", caught);
				
			}

			@Override
			public void onSuccess(Boolean result) {
				Generate generate = new Generate();
				
				generate.setRequiredList(model.getRequiredList());
				
				for(int i = 0; i < generate.getRequiredList().size(); i++){
					GWT.log(generate.getRequiredList().get(i).toString());
				}	
			}
			
		});
		
	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
		// TODO Auto-generated method stub
		
	}
}
