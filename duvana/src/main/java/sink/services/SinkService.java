package sink.services;

import java.util.Date;
import java.util.List;

import sink.bean.SinkBean;

public interface SinkService  {

	/**
	 * 
	 * @param sink
	 * @return
	 */
	SinkBean prepareAndSave(SinkBean sink);
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<SinkBean> findAllSinks(Date startDate, Date endDate);
}
