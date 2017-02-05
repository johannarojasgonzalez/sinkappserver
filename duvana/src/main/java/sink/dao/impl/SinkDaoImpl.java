package sink.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sink.bean.SinkBean;
import sink.dao.SinkCustomDao;

@Repository
public class SinkDaoImpl implements SinkCustomDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	public List<SinkBean> findAllSinks(Date startDate, Date endDate) {
		// TODO à implementer
		//sessionFactory.getCurrentSession();
		return null;
	}

	

}
