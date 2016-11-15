package br.com.authentication.api.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.authentication.api.services.UserService;
import br.com.authentication.api.services.entity.User;
import br.com.authentication.api.services.resources.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController implements Resource<User> {
	private @Autowired UserService userBusiness;
	
	@Override
	@RequestMapping(method = RequestMethod.GET) @ResponseStatus(value = HttpStatus.OK)
	public User get(User entity) {
		// TODO GET METHOD
		return null;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST) @ResponseStatus(value = HttpStatus.OK) 
	public User post(final @RequestBody User entity) {
		return userBusiness.create(entity);
	}

	@Override
	public User put(User entity) {
		// TODO PUT METHOD
		return null;
	}

	@Override
	public User delete(User entity) {
		// TODO DELETE METHOD
		return null;
	}

}
