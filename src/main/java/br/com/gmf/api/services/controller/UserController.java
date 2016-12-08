package br.com.gmf.api.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gmf.api.services.UserService;
import br.com.gmf.api.services.entity.User;
import br.com.gmf.api.services.resources.Resource;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/user")
public class UserController implements Resource<User, Long> {
	private @Autowired UserService userService;
	
	@ApiOperation(value = "Serviço para obtenção de todos os usuários", nickname = "get", 
			notes = "Obtenção de todos os usuários cadastrados no sistema")
	@Override @RequestMapping(method = RequestMethod.GET) @ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<User> get() {
		return userService.getAll();
	}
	
	@Override
	public @ResponseBody User get(final Long id) {
		return null;
	}

	@ApiOperation(value = "Serviço para criação de usuário", nickname = "create", notes = "Criação de um novo usuário")
	@Override @RequestMapping(method = RequestMethod.POST) @ResponseStatus(value = HttpStatus.CREATED) 
	public User post(final @RequestBody User entity) {
		return userService.create(entity);
	}

	@Override
	public User put(User entity) {
		return null;
	}

	@Override
	public User delete(User entity) {
		return null;
	}

}
