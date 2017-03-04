package sink.dao;

import sink.bean.UserBean;

public interface UserCustomDao {

	/**
	 * 
	 * @param imiNumber
	 * @return
	 */
	UserBean findByImiNumber(String imiNumber);
}
