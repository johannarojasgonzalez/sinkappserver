package sink.services;

import sink.bean.UserBean;

public interface UserService {
	
	/**
	 * Find user by imeiNumber
	 * @param imeiNumber
	 * @return
	 */
	UserBean findByImeiNumber(String imeiNumber);
}
