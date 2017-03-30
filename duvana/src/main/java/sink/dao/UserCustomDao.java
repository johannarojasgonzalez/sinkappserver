package sink.dao;

import sink.bean.UserBean;

public interface UserCustomDao {

	/**
	 * Find user by imei number
	 * @param imieNumber
	 * @return
	 */
	UserBean findByImeiNumber(String imeiNumber);
}
