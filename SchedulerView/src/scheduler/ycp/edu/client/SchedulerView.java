package scheduler.ycp.edu.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;


import scheduler.ycp.edu.shared.Generate;
import scheduler.ycp.edu.shared.Schedule; 


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SchedulerView implements EntryPoint {

	public void onModuleLoad() {
		FlowPanel panel = new FlowPanel();
		
//		SchedulerViewView schedulerView = new SchedulerViewView();
//		panel.add(schedulerView);
//		Schedule model = new Schedule();
//		
//		schedulerView.setModel(model);
//		schedulerView.update();
		
		GenerateView generateView = new GenerateView();

		Generate generate = new Generate();
		generate.setSchedule(new Schedule());

		//generateView.setModel(generate);

		panel.add(generateView);

		RootLayoutPanel.get().add(panel);
		RootLayoutPanel.get().setWidgetTopBottom(panel, 10.0, Unit.PX, 10.0, Unit.PX);
		RootLayoutPanel.get().setWidgetLeftRight(panel, 10.0, Unit.PX, 10.0, Unit.PX);
	}
}
