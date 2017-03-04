package sink.services;

import sink.bean.UserBean;

public interface UserService {

	UserBean findByImiNumber(String userId);
}
