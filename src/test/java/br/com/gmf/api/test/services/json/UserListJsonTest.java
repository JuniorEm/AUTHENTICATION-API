package br.com.gmf.api.test.services.json;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.springframework.boot.test.json.JacksonTester;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gmf.api.services.entity.User;
import br.com.gmf.api.test.AbstractJsonTest;

public class UserListJsonTest extends AbstractJsonTest<List<User>> {
	private static final String JSON_PATH = "/user/users.json";
	private static final String ERROR_MESSAGE = "Ocorreu um erro no processamento do teste, corrija-o";
	private JacksonTester<User> model;
	
	@Before
	public void setup() {
		final ObjectMapper mapper = new ObjectMapper();
		JacksonTester.initFields(this, mapper);
		JacksonTester.initFields(this, mapper);
	}

	public void serializeJson() throws IOException {
		final User first = new User();
		first.setName("Harvey Dent");
		first.setLogin("hdent");
		first.setPassword("hvey12");
		
		final User second = new User();
		second.setName("Joker");
		second.setLogin("jk0");
		second.setPassword("mylastlaugh1");
		
		final User third = new User();
		third.setName("Edward Nigma");
		third.setLogin("enigma0");
		third.setPassword("whowillbedlast");

		final List<User> users = Arrays.asList(first, second, third);
		
		assertThat(this.json.write(users)).isEqualToJson(JSON_PATH);
		
		users.forEach(selected -> {
			try {
				assertThat(this.model.write(selected)).hasJsonPathStringValue("@.name");
				assertThat(this.model.write(selected)).hasJsonPathStringValue("@.login");
				assertThat(this.model.write(selected)).hasJsonPathStringValue("@.password");
			} catch (final IOException e) {
				throw new RuntimeException(ERROR_MESSAGE);
			}
		});
	}
	
	public void deserializeJson() throws IOException {
		
	}
}
