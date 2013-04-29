package scheduler.ycp.edu.client;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateKeyListServiceAsync {

	void pullDatabase(AsyncCallback<Boolean> callback);
	
	void pullKeyList(AsyncCallback<ArrayList<String>> callback);
}
