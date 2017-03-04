package sink.dao;

import java.util.Date;
import java.util.List;

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
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<SinkBean> findAllSinks(Date startDate, Date endDate);
}
 	