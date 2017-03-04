package sink.dao;

import sink.bean.ClientBean;

public interface ClientCustomDao {
	
	/**
	 * 
	 * @param clientName
	 * @return
	 */
	ClientBean findByName(String clientName);

}
