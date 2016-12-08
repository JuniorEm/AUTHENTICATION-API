package br.com.gmf.api.services.entity.builder;

import br.com.gmf.api.services.entity.User;

public class UserBuilder {
	private User user;
	
	public UserBuilder() {
		user = new User();
	}
	
	public UserBuilder id(final Long id) {
		user.setId(id);
		return this;
	}

	public UserBuilder name(final String name) {
		user.setName(name);
		return this;
	}

	public UserBuilder login(final String login) {
		user.setLogin(login);
		return this;
	}

	public UserBuilder password(final String password) {
		user.setPassword(password);
		return this;
	}
	
	public User build() {
		return user;
	}
	
}
