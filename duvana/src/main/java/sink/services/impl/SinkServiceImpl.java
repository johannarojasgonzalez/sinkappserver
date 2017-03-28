package sink.services.impl;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import sink.bean.AddressBean;
import sink.bean.ClientBean;
import sink.bean.SinkBean;
import sink.bean.UserBean;
import sink.dao.AddressDao;
import sink.dao.ClientDao;
import sink.dao.SinkDao;
import sink.services.SinkService;

@Service
public class SinkServiceImpl implements SinkService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SinkServiceImpl.class);

	@Autowired
	private SinkDao sinkDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private ClientDao clientDao;
	
	public boolean checkReferenceExists(SinkBean sink, boolean stepBefore) {
		ClientBean client = getClient(sink);
		if (client != null) {
			return findByReferenceAndClientAndStep(sink.getReference(), client.getName(), stepBefore);
		}
		return false;
	}

	public List<String> prepareAndSave(Set<SinkBean> sinks, UserBean user) {
		List<String> fileNames = new ArrayList<String>();
		if (!CollectionUtils.isEmpty(sinks)) {
			for (SinkBean sink : sinks) {
				ClientBean client = getClient(sink);
				if (client != null) {
					SinkBean existingSink = sinkDao.findByReferenceAndClient(sink.getReference(), client.getId());
					if (existingSink != null) {
						// update
						existingSink.setUserUpdate(user);
						updateData(fileNames, sink, existingSink);
					} else {
						// create
						setClientAndAddressAndUser(sink, client, user);
						if (sinkDao.save(sink) != null) {
							fileNames.add(sink.getFileName());
						}
					}
				} else {					
					LOGGER.warn(String.format("Client for reference %s does not exists", sink.getReference()));
				}
			}
		}
		return fileNames;
	}

	public SinkBean prepareAndSave(SinkBean sink, UserBean user) {
		ClientBean client = getClient(sink);
		if (client != null) {
			SinkBean existingSink = sinkDao.findByReferenceAndClient(
					sink.getReference(), client.getId());
			if (existingSink != null) {
				// update
				existingSink.setUserUpdate(user);
				if ((existingSink.getImageBefore() != null)) {
					return copyAfterData(sink, existingSink);
				} else if ((existingSink.getImageAfter() != null)) {
					return copyBeforerData(sink, existingSink);
				}
			} else {
				setClientAndAddressAndUser(sink, client, user);
				return sinkDao.save(sink);
			}
		}
		return null;
	}
	
	public ArrayList<SinkBean> findAllSinksByDateAnClient(Date startDate, Date endDate, String clientName) {
		return sinkDao.findAllSinksByDateAnClient(startDate, endDate, clientName);
	}
	
	private void updateData(List<String> fileNames, SinkBean sink, SinkBean existingSink) {
		if (	(existingSink.getImageBefore() != null && copyAfterData(sink, existingSink) != null)
			|| 	(existingSink.getImageAfter() != null && copyBeforerData(sink, existingSink) != null)) {
			fileNames.add(sink.getFileName());
		}
	}

	private void setClientAndAddressAndUser(SinkBean sink, ClientBean client, UserBean user) {
		sink.setClient(client);
		sink.setUserCreation(user);
		createAddress(sink);
	}

	private AddressBean createAddress(SinkBean sink) {
		AddressBean address = sink.getAddress();
		if (address != null) {
			return addressDao.save(address);
		}
		return null;
	}

	private SinkBean copyAfterData(SinkBean sink, SinkBean existingSink) {
		existingSink.setImageAfter(sink.getImageAfter());
		existingSink.setLength(sink.getLength());
		existingSink.setObservations(sink.getObservations());
		existingSink.setPipeLineDiameterId(sink.getPipeLineDiameterId());
		existingSink.setPipeLineLength(sink.getPipeLineLength());
		existingSink.setPlumbOptionId(sink.getPlumbOptionId());
		existingSink.setSinkStatusId(sink.getSinkStatusId());
		existingSink.setSinkTypeId(sink.getSinkTypeId());
		existingSink.setAddress(createAddress(sink));
		existingSink.setSinkUpdateDate(new Date());
		return sinkDao.save(existingSink);
	}

	private SinkBean copyBeforerData(SinkBean sink, SinkBean existingSink) {
		existingSink.setImageBefore(sink.getImageBefore());
		existingSink.setSinkUpdateDate(new Date());
		SinkBean save = sinkDao.save(existingSink);
		return save;
	}

	private ClientBean getClient(SinkBean sink) {
		ClientBean client = null;
		if (sink.getClient() != null) {
			String clientName = sink.getClient().getName();
			client = clientDao.findByName(clientName);
			if(client == null) {
				LOGGER.warn(String.format("The client %s is not known", clientName));
			}
		}
		return client;
	}

	public boolean deleteSink(SinkBean sinkBean) {
		sinkDao.delete(sinkBean.getId());
		return !sinkDao.exists(sinkBean.getId());
	}

	public SinkBean update(SinkBean sink, UserBean user) {
		ClientBean client = getClient(sink);
		if (client != null) {
			SinkBean existingSink = sinkDao.findByReferenceAndClient(sink.getReference(), client.getId());
			if (existingSink != null) {
				// update
				Blob imageBefore = existingSink.getImageBefore();
				BeanUtils.copyProperties(sink, existingSink, "address", "client", "id");
				if(existingSink.getImageBefore() == null) {
					existingSink.setImageBefore(imageBefore);
				}
				existingSink.setAddress(createAddress(sink));
				existingSink.setSinkUpdateDate(new Date());
				existingSink.setUserUpdate(user);
				return sinkDao.save(existingSink);
			}
		}
		return null;
	}

	public boolean findByReferenceAndClientAndStep(String reference,
			String clientName, boolean stepBefore) {
		return !CollectionUtils.isEmpty(sinkDao.findByReferenceAndClientAndStep(reference, clientName, stepBefore));
	}

}
