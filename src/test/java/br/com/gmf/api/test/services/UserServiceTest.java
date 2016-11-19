package br.com.authentication.api.test.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import br.com.authentication.api.services.entity.User;
import br.com.authentication.api.test.AbstractServiceTest;

/**
 * Test for user service.
 * 
 * @author Junior
 *
 */
public class UserServiceTest extends AbstractServiceTest {
	private static final Long ZERO = 0L;
	private static final String SERVICE_PATH = "/api/user";

	@Test
	public void post() throws IOException {
		final User user = new User();
		user.setName("AUTO_NAME");
		user.setLogin("AUTO_TEST");
		user.setPassword("AUTO_PASSWORD");

		final User post = post(SERVICE_PATH, user, User.class);

		assertNotNull(post);
		assertNotNull(post.getId());
		assertFalse(post.getId().equals(ZERO));
		assertEquals(user.getLogin(), post.getLogin());
		assertEquals(user.getName(), post.getName());
		assertEquals(user.getPassword(), post.getPassword());
	}
}
