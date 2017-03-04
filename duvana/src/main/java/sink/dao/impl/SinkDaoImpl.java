package sink.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
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
	public List<SinkBean> findAllSinks(Date startDate, Date endDate) {
		Criteria criteria = getCurrentSession().createCriteria(SinkBean.class);
		return criteria.list();
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
