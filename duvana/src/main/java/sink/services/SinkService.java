package sink.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import sink.bean.SinkBean;
import sink.bean.UserBean;
import sink.enums.ProfileEnum;

public interface SinkService {

	/**
	 * 
	 * @param sinks
	 * @param user
	 * @return a map with file names and a flag to say it has been saved (true) or it already exists (false)
	 */
	HashMap<String, Boolean> prepareAndSave(Set<SinkBean> sinks, UserBean user, ProfileEnum profile);
	
	/**
	 * Check if reference exists
	 * @param sinkBean
	 * @return
	 */	
	boolean checkReferenceExists(SinkBean sinkBean, boolean stepBefore);

	/**
	 * 
	 * @param sinks
	 * @param user
	 * @return
	 */
	SinkBean prepareAndSave(SinkBean sinks, UserBean user);
	
	/**
	 * 
	 * @param sinks
	 * @param user
	 * @return
	 */
	SinkBean update(SinkBean sinks, UserBean user);

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	ArrayList<SinkBean> findAllSinksByDateAnClient(Date startDate, Date endDate, String clientName);
	
	/**
	 * 
	 * @param sinkBean
	 * @return
	 */
	boolean deleteSink(SinkBean sinkBean);
	
	/**
	 * 
	 * @param reference
	 * @param clientName
	 * @param stepBefore
	 * @return
	 */
	public boolean findByReferenceAndClientAndStep(String reference, String clientName, boolean stepBefore);
	
}
