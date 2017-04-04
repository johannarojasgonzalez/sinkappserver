package sink.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sink.bean.ClientBean;
import sink.dao.ClientDao;
import sink.services.ClientService;

import com.google.common.collect.Lists;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;

	@Override
	public ArrayList<ClientBean> findAll() {
		Iterable<ClientBean> clients = clientDao.findAll();		
		return Lists.newArrayList(clients);
	}
	
}
