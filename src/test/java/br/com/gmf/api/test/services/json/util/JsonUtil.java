package br.com.gmf.api.test.services.json.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.json.JacksonTester;

/**
 * Util for JsonTests to serialize and deserialize
 * @author Junior
 *
 */
public class JsonUtil {

	public static <E> void assertStringJsonPath(final JacksonTester<E> jacksonTester, final E entity,
			final String... args) {
		final List<String> list = Arrays.asList(args);

		list.forEach((s) -> {
			try {
				assertThat(jacksonTester.write(entity)).hasJsonPathStringValue(s);
			} catch (final IOException e) {
				throw new RuntimeException(e);
			}
		});

	}

	public static <E> void assertNumberJsonPath(final JacksonTester<E> jacksonTester, final E entity,
			final String... args) {
		final List<String> asList = Arrays.asList(args);

		asList.forEach((s) -> {
			try {
				assertThat(jacksonTester.write(entity)).hasJsonPathNumberValue(s);
			} catch (final IOException e) {
				throw new RuntimeException(e);
			}
		});
	}
}
