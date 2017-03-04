package sink.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sink.bean.UserBean;
import sink.dao.UserDao;
import sink.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserBean findByImiNumber(String imiNumber) {
		return userDao.findByImiNumber(imiNumber);
	}

}
