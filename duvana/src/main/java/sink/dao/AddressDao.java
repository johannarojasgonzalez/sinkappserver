package sink.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import sink.bean.AddressBean;

@Transactional
public interface AddressDao extends CrudRepository<AddressBean, Long> {
	
}
