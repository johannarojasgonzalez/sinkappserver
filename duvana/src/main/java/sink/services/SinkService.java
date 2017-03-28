package sink.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import sink.bean.SinkBean;
import sink.bean.UserBean;

public interface SinkService {

	/**
	 * 
	 * @param sinks
	 * @param user
	 * @return a list with file names (it means the bean has been saved)
	 */
	List<String> prepareAndSave(Set<SinkBean> sinks, UserBean user);
	
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
	
	public boolean findByReferenceAndClientAndStep(String reference, String clientName, boolean stepBefore);
	
}
