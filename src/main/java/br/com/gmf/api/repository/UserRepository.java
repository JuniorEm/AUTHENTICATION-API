package br.com.gmf.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gmf.api.services.entity.User;

/**
 * User Data Access Object
 * @author Junior
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByLoginAndPassword(final String login, final String password);
	
	User findByLogin(final String login);
}
