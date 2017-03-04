package sink.dao;

import org.springframework.data.repository.CrudRepository;

import sink.bean.ClientBean;

public interface ClientDao extends CrudRepository<ClientBean, Long>,
		ClientCustomDao {

}
