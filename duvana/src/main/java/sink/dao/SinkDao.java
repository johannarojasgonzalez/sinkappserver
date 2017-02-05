package sink.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import sink.bean.SinkBean;

@Transactional
public interface SinkDao extends CrudRepository<SinkBean, Long>, SinkCustomDao {

}
