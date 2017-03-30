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
	 * search if pair reference-client exists
	 * if step before check also imageBefore exists
	 * else check image after exists
	 * @param reference
	 * @param clientId
	 * @return
	 */
	SinkBean findByReferenceAndClientAndStep(String reference, String clientName, boolean stepBefore);
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	ArrayList<SinkBean> findAllSinksByDateAnClientAndReference(Date startDate, Date endDate, String clientName, String reference);
	
}
 	