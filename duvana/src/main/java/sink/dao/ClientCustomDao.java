package sink.dao;

import sink.bean.ClientBean;

public interface ClientCustomDao {
	
	/**
	 * Find client by name
	 * 
	 * @param clientName
	 * @return
	 */
	ClientBean findByName(String clientName);
	
}
