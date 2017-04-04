package sink.services;

import java.util.ArrayList;

import sink.bean.ClientBean;

public interface ClientService {
	
	/**
	 * find all clients
	 * @return
	 */
	ArrayList<ClientBean> findAll();
	
}
