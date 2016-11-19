package br.com.gmf.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gmf.api.repository.UserRepository;
import br.com.gmf.api.services.entity.User;

/**
 * Service class for User
 * @author Junior
 *
 */
@Service
public class UserService {
	private static final String USER_ALREADY_EXISTS = "O usuário já existe!";
	private @Autowired UserRepository userDAO;
	
	public User create(final User user) {
		if (userDAO.findByLogin(user.getLogin()) == null) {			
			return userDAO.save(user);
		} else {
			throw new RuntimeException(USER_ALREADY_EXISTS);
		}
	}
}
