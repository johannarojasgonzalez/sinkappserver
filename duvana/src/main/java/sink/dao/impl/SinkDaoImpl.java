package sink.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import sink.bean.SinkBean;
import sink.dao.SinkCustomDao;

@Transactional
@Repository
public class SinkDaoImpl extends AbstractDao implements SinkCustomDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public ArrayList<SinkBean> findAllSinksByDateAnClient(Date startDate, Date endDate, String clientName) {
		String strQuery = "FROM SinkBean WHERE sinkCreationDate BETWEEN :startDate AND :endDate AND client.name = :clientName";
		Query query = getCurrentSession().createQuery(strQuery);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		query.setParameter("clientName", clientName);
		return (ArrayList<SinkBean>) query.list();
	}

	@SuppressWarnings("unchecked")
	public SinkBean findByReferenceAndClient(String reference, Long clientId) {
		Query query = getCurrentSession().createQuery("FROM SinkBean WHERE reference = :reference AND client.id = :clientId");
		query.setParameter("reference", reference);
		query.setParameter("clientId", clientId);
		query.setFirstResult(0);
		List<SinkBean> results = (List<SinkBean>) query.list();
		if (CollectionUtils.hasUniqueObject(results)) {
			return results.get(0);
		}
		return null;
	}

}
