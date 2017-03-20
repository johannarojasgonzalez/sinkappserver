package sink.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sink.bean.SinkBean;

public interface SinkDao extends CrudRepository<SinkBean, Long>, SinkCustomDao {

	@Modifying
	@Query("delete from SinkBean where id = ?1")
	void delete(Long entityId);
}
