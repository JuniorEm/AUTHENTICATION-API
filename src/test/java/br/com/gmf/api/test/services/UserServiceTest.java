package br.com.gmf.api.test.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

import br.com.gmf.api.services.entity.User;
import br.com.gmf.api.services.entity.builder.UserBuilder;
import br.com.gmf.api.test.AbstractServiceTest;

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
	
	@Test
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void get() {
		final User first = new UserBuilder().name("TREE_NAME").login("TREE_LOGIN").password("TREE_PASS").build();
		final User second = new UserBuilder().name("TRII_NAME").login("TRII_LOGIN").password("TRII_PASS").build();
		
		final User firstObtained = post(SERVICE_PATH, first, User.class);
		final User secondObtained = post(SERVICE_PATH, second, User.class);
		final List<User> expected = Arrays.asList(firstObtained, secondObtained);
		
		final List<LinkedHashMap> actual = get(SERVICE_PATH, List.class);
		
		assertNotNull(actual);
		assertFalse(actual == null);
		assertFalse(actual.isEmpty());
		
		for (int i = 0; i < expected.size(); i++) {
			final User userExpected = expected.get(i);
			final LinkedHashMap userActual = actual.get(i);
			
			final Long id = Long.valueOf(userActual.get("id").toString());
			final String name = userActual.get("name").toString();
			final String login = userActual.get("login").toString();
			final String password = userActual.get("password").toString();
			
			assertFalse(id.equals(ZERO));
			assertEquals(userExpected.getName(), name);
			assertEquals(userExpected.getLogin(), login);
			assertEquals(userExpected.getPassword(), password);
		}
	}
}
