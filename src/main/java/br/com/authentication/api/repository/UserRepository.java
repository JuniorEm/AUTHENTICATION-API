package br.com.authentication.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.authentication.api.services.entity.User;

/**
 * The User DATA ACCESS OBJECT CLASS
 * @author Junior
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByLoginAndPassword(final String login, final String password);
	
	User findByLogin(final String login);
}
