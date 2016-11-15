package br.com.authentication.api.test.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.assertj.core.api.AbstractObjectAssert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	private JacksonTester<User> json;

	@Before
	public void setup() {
		ObjectMapper mapper = new ObjectMapper();
		JacksonTester.initFields(this, mapper);
	}

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
		serializeJson(post);
	}

	private void serializeJson(final User user) throws IOException {
		assertThat(this.json.write(user)).isEqualToJson("/user-post-test.json");
		assertJsonPath(user, "@.id");
		assertJsonPath(user, "@.name");
		assertJsonPath(user, "@.login");
		assertJsonPath(user, "@.password");

		assertThat(this.json.write(user)).extractingJsonPathNumberValue("@.id").isEqualTo(user.getId().intValue());
		assertThat(this.json.write(user)).extractingJsonPathStringValue("@.name").isEqualTo(user.getName());
		assertThat(this.json.write(user)).extractingJsonPathStringValue("@.login").isEqualTo(user.getLogin());
		assertThat(this.json.write(user)).extractingJsonPathStringValue("@.password").isEqualTo(user.getPassword());
	}

	private void assertJsonPath(final User user, final String path) throws IOException {
		assertThat(this.json.write(user)).hasJsonPathStringValue("@.login");
	}
}
