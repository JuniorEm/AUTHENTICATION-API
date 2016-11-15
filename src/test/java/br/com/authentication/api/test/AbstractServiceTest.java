package br.com.authentication.api.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.authentication.api.connector.ServiceConnector;

/**
 * Class config for Integrated Service Test.
 * @author Junior
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public abstract class AbstractServiceTest {
	private @Autowired ServiceConnector serviceConnector;

    protected final <E> E get(final String service, final Class<E> returnType) {
        return serviceConnector.get(service, returnType);
    }
    
    protected final <E> E get(final String service, final Object param, final String paramName, final Class<E> returnType) {
        return serviceConnector.get(service, paramName, param, returnType);
    }

    protected final <E> E post(final String service, final Object param, final Class<E> returnType) {
        return serviceConnector.post(service, param, returnType);
    }
    
    protected final void put(final String service, final Object param) {
        serviceConnector.put(service, param);
    }
}
