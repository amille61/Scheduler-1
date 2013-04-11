package scheduler.ycp.edu.client;

import com.google.gwt.core.client.GWT;


public class RPC {
	public static final GenerateServiceAsync generateService =
			GWT.create(GenerateService.class);	
	
	public static final CreateKeyListServiceAsync keyListService =
			GWT.create(CreateKeyListService.class);	

}
