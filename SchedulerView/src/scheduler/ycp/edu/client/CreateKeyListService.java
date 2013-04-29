package scheduler.ycp.edu.client;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("keylist")
public interface CreateKeyListService extends RemoteService{
		
	public Boolean pullDatabase();
	public ArrayList<String> pullKeyList();
		
}
