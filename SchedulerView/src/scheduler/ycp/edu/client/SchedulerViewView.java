package scheduler.ycp.edu.client;

import java.util.Collection;
import scheduler.ycp.edu.shared.FakeDatabase;
import scheduler.ycp.edu.shared.Schedule;
import scheduler.ycp.edu.shared.IPublisher;
import scheduler.ycp.edu.shared.ISubscriber;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;

public class SchedulerViewView extends Composite implements ISubscriber{
	private Schedule model;
	
	private ListBox requiredListBox;
	private ListBox optionalListBox;
	private ListBox courseListBox;
	private String c;
	FakeDatabase database;
	
	public SchedulerViewView() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("687px", "479px");
		
		courseListBox = new ListBox();
		layoutPanel.add(courseListBox);
		layoutPanel.setWidgetLeftWidth(courseListBox, 37.0, Unit.PX, 185.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(courseListBox, 33.0, Unit.PX, 392.0, Unit.PX);
		
		Collection<String> tempCourseList = database.getDatabase().keySet();
		for(int i = 0; i < tempCourseList.size(); i++){
			if(tempCourseList.iterator().hasNext()){
				courseListBox.addItem(tempCourseList.iterator().next());
			}
		}
		
		//courseListBox.setVisibleItemCount(5);
		
		Button buttonAddRequired = new Button("New button");
		buttonAddRequired.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleAddRequired();
			}
		});
		buttonAddRequired.setText("Add >>>");
		layoutPanel.add(buttonAddRequired);
		layoutPanel.setWidgetLeftWidth(buttonAddRequired, 279.0, Unit.PX, 95.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(buttonAddRequired, 51.0, Unit.PX, 48.0, Unit.PX);
		
		Button buttonRemoveRequired = new Button("New button");
		buttonRemoveRequired.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleRemoveRequired();
			}
		});
		buttonRemoveRequired.setText("<<< Remove");
		layoutPanel.add(buttonRemoveRequired);
		layoutPanel.setWidgetLeftWidth(buttonRemoveRequired, 279.0, Unit.PX, 95.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(buttonRemoveRequired, 119.0, Unit.PX, 48.0, Unit.PX);
		
		requiredListBox = new ListBox();
		layoutPanel.add(requiredListBox);
		layoutPanel.setWidgetLeftWidth(requiredListBox, 463.0, Unit.PX, 172.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(requiredListBox, 33.0, Unit.PX, 159.0, Unit.PX);
		requiredListBox.setVisibleItemCount(5);
		
		optionalListBox = new ListBox();
		optionalListBox.setVisibleItemCount(5);
		layoutPanel.add(optionalListBox);
		layoutPanel.setWidgetLeftWidth(optionalListBox, 463.0, Unit.PX, 172.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(optionalListBox, 250.0, Unit.PX, 159.0, Unit.PX);
		
		Button buttonAddOptional = new Button("New button");
		buttonAddOptional.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleAddOptional();
			}
		});
		buttonAddOptional.setText("Add >>>");
		layoutPanel.add(buttonAddOptional);
		layoutPanel.setWidgetLeftWidth(buttonAddOptional, 279.0, Unit.PX, 95.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(buttonAddOptional, 266.0, Unit.PX, 48.0, Unit.PX);
		
		Button buttonRemoveOptional = new Button("New button");
		buttonRemoveOptional.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleRemoveOptional();
			}
		});
		buttonRemoveOptional.setText("<<< Remove");
		layoutPanel.add(buttonRemoveOptional);
		layoutPanel.setWidgetLeftWidth(buttonRemoveOptional, 279.0, Unit.PX, 95.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(buttonRemoveOptional, 337.0, Unit.PX, 48.0, Unit.PX);
		
		CheckBox checkBox8AM = new CheckBox("No 8AM Classes");
		layoutPanel.add(checkBox8AM);
		layoutPanel.setWidgetLeftWidth(checkBox8AM, 37.0, Unit.PX, 155.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(checkBox8AM, 442.0, Unit.PX, 20.0, Unit.PX);
		
		CheckBox checkBoxNoEvening = new CheckBox("No Evening Classes ");
		layoutPanel.add(checkBoxNoEvening);
		layoutPanel.setWidgetLeftWidth(checkBoxNoEvening, 206.0, Unit.PX, 168.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(checkBoxNoEvening, 442.0, Unit.PX, 20.0, Unit.PX);
		
		Label labelCourseList = new Label("Course List");
		layoutPanel.add(labelCourseList);
		layoutPanel.setWidgetLeftWidth(labelCourseList, 39.0, Unit.PX, 102.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(labelCourseList, 9.0, Unit.PX, 18.0, Unit.PX);
		
		Label labelRequiredCourses = new Label("Required Courses");
		layoutPanel.add(labelRequiredCourses);
		layoutPanel.setWidgetLeftWidth(labelRequiredCourses, 467.0, Unit.PX, 138.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(labelRequiredCourses, 9.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblOptionalCourses = new Label("Optional Courses");
		layoutPanel.add(lblOptionalCourses);
		layoutPanel.setWidgetLeftWidth(lblOptionalCourses, 467.0, Unit.PX, 108.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblOptionalCourses, 226.0, Unit.PX, 18.0, Unit.PX);
	}
	

	protected void handleAddRequired() {
		int index = courseListBox.getSelectedIndex();
		if (index >= 0) {
			String item = courseListBox.getItemText(index);
			c = String.valueOf(item);
			model.addRequired(c);
		}		
	}
	
	protected void handleRemoveRequired() {
		int index = requiredListBox.getSelectedIndex();
		if (index >= 0) {
			String item = requiredListBox.getItemText(index);
			c = String.valueOf(item);
			model.removeRequired(c);
		}		
	}
	
	protected void handleAddOptional() {
		int index = courseListBox.getSelectedIndex();
		if (index >= 0) {
			String item = courseListBox.getItemText(index);
			c = String.valueOf(item);
			model.addOptional(c);
		}		
	}
	
	protected void handleRemoveOptional() {
		int index = optionalListBox.getSelectedIndex();
		if (index >= 0) {
			String item = optionalListBox.getItemText(index);
			c = String.valueOf(item);
			model.removeOptional(c);
		}		
	}
	public void setModel(Schedule model) {
		this.model = model;
		this.model.subscribe(Schedule.Events.ADD_REQUIRED, this);
		this.model.subscribe(Schedule.Events.ADD_OPTIONAL, this);
		this.model.subscribe(Schedule.Events.REMOVE_REQUIRED, this);
		this.model.subscribe(Schedule.Events.REMOVE_OPTIONAL, this);
	}


	public void update() {
		requiredListBox.clear();
		optionalListBox.clear();
		courseListBox.clear();
		//for (String c : String.values()) {
			if (model.getRequiredList().contains(c)) {
				requiredListBox.addItem(c);
			} else if (model.getOptionalList().contains(c)) {
				optionalListBox.addItem(c);
			} else {
				courseListBox.addItem(c);
			}
	//	}	
	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
		update();
		
	}
}
