package sink.dao;

import java.util.ArrayList;
import java.util.Date;

import sink.bean.SinkBean;

public interface SinkCustomDao {

	/**
	 * 
	 * @param reference
	 * @return
	 */
	SinkBean findByReferenceAndClient(String reference, Long clientId);
	
	/**
	 * 
	 * @param reference
	 * @param clientId
	 * @return
	 */
	ArrayList<SinkBean> findByReferenceAndClientAndStep(String reference, String clientName, boolean stepBefore);
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	ArrayList<SinkBean> findAllSinksByDateAnClient(Date startDate, Date endDate, String clientName);
	
}
 	