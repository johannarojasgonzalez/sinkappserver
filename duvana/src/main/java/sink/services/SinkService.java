package sink.services;

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
	 * 
	 * @param sinks
	 * @param user
	 * @return
	 */
	SinkBean prepareAndSave(SinkBean sinks, UserBean user);

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<SinkBean> findAllSinks(Date startDate, Date endDate);
}
