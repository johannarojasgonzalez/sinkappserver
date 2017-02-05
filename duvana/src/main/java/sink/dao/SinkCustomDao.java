package sink.dao;

import java.util.Date;
import java.util.List;

import sink.bean.SinkBean;

public interface SinkCustomDao {

	List<SinkBean> findAllSinks(Date startDate, Date endDate);
}
 	