package sink.dao;

import org.springframework.data.repository.CrudRepository;

import sink.bean.UserBean;

public interface UserDao extends CrudRepository<UserBean, Long>, UserCustomDao {

}
