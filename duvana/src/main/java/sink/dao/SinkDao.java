package sink.dao;

import org.springframework.data.repository.CrudRepository;

import sink.bean.SinkBean;

public interface SinkDao extends CrudRepository<SinkBean, Long>, SinkCustomDao {

}
