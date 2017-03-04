package sink.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sink.bean.UserBean;
import sink.dao.UserCustomDao;

@Transactional
@Repository
public class UserDaoImpl extends AbstractDao implements UserCustomDao {

	public UserBean findByImiNumber(String imiNumber) {
		Criteria criteria = getCurrentSession().createCriteria(UserBean.class);
		criteria = criteria.add(Restrictions.eq("imiNumber", imiNumber));
		return (UserBean) criteria.uniqueResult();
	}

}
