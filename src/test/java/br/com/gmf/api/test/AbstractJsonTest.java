package br.com.gmf.api.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractJsonTest<T> {
	protected JacksonTester<T> json;

	@Before
	public void setup() {
		final ObjectMapper mapper = new ObjectMapper();
		JacksonTester.initFields(this, mapper);
	}
	
	@Test
	public abstract void serializeJson() throws IOException;
	
	@Test
	public abstract void deserializeJson() throws IOException;
	
}
