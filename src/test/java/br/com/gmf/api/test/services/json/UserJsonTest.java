package br.com.gmf.api.test.services.json;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gmf.api.services.entity.User;
import br.com.gmf.api.test.services.json.util.JsonUtil;

/**
 * Test for serialize and deserialize Json
 * 
 * @author Junior
 *
 */
@RunWith(SpringRunner.class)
@JsonTest
@PropertySource("classpath:/application-test.properties")
@Profile("test")
public class UserJsonTest {

	private static final String JSON_PATH = "/user/user.json";
	private JacksonTester<User> json;
		
	@Before
	public void setup() {
		final ObjectMapper mapper = new ObjectMapper();
		JacksonTester.initFields(this, mapper);
	}

	@Test
	public void serializeJson() throws IOException {
		final User user = new User();
		user.setName("Oswald Cobblepot");
		user.setLogin("oswald_cobble");
		user.setPassword("oswald_pass");

		assertThat(this.json.write(user)).isEqualToJson(JSON_PATH);
		JsonUtil.assertStringJsonPath(this.json, user, "@.name", "@.login", "@.password");

		assertThat(this.json.write(user)).extractingJsonPathStringValue("@.name").isEqualTo(user.getName());
		assertThat(this.json.write(user)).extractingJsonPathStringValue("@.login").isEqualTo(user.getLogin());
		assertThat(this.json.write(user)).extractingJsonPathStringValue("@.password").isEqualTo(user.getPassword());
	}

	@Test
	public void deserializeJson() throws IOException {
		final String name = "Oswald Cobblepot";
		final String login = "oswald_cobble";
		final String password = "oswald_pass";

		final StringBuilder builder = new StringBuilder();

		final String content = builder.append("{\"name\":")
				.append("\"Oswald Cobblepot\",").append("\"login\":").append("\"oswald_cobble\",")
				.append("\"password\":").append("\"oswald_pass\"}").toString();

		final User user = new User();
		user.setName(name);
		user.setLogin(login);
		user.setPassword(password);

		final User parsedObject = this.json.parseObject(content);

		assertThat(this.json.parse(content)).isEqualTo(user);
		assertThat(parsedObject.getName()).isEqualTo(name);
		assertThat(parsedObject.getLogin()).isEqualTo(login);
		assertThat(parsedObject.getPassword()).isEqualTo(password);
	}

}
