package sink.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sink.bean.AddressBean;
import sink.bean.SinkBean;
import sink.dao.AddressDao;
import sink.dao.SinkDao;
import sink.services.SinkService;

@Service
public class SinkServiceImpl implements SinkService {

	@Autowired
	private SinkDao sinkDao;

	@Autowired
	private AddressDao addressDao;

	public SinkBean prepareAndSave(SinkBean sink) {
		AddressBean address = sink.getAdresse();
		if (address != null) {
			addressDao.save(address);
			sink.setSinkCreationDate(new Date());
			return sinkDao.save(sink);
		}
		return null;
	}

	public List<SinkBean> findAllSinks(Date startDate, Date endDate) {
		return sinkDao.findAllSinks(startDate, endDate);
	}

}
