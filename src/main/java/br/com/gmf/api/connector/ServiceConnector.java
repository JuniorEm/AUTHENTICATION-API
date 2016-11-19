package br.com.gmf.api.connector;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Connector for service calls
 * @author Junior
 *
 */
@Component
public class ServiceConnector {
	
	@Value("${service.prefix}") private String prefix;
	
	public <E> E get(final String service, final Class<E> type) {
		final RestTemplate template = new RestTemplate();
		return template.getForObject(getURI(service), type);
	}
	
	public <E> E get(final String service, final String paramName, final Object param, final Class<E> type) {
		final Map<String, Object> map = new HashMap<>();
		map.put(paramName, param);
		
		final RestTemplate template = new RestTemplate();
		return template.getForObject(getURI(service, paramName), type, map);
	}
	
	public <E> E post(final String service, final Object param, final Class<E> type) {
		final RestTemplate template = new RestTemplate();
		return template.postForObject(getURI(service), param, type);
	}
		
	public void put(final String service, final Object param) {
		final RestTemplate template = new RestTemplate();
		template.put(getURI(service), param);
	}
	
	public void delete(final String service, final String paramName, final Object param) {
		final RestTemplate template = new RestTemplate();
		final Map<String, Object> map = new HashMap<>();
		map.put(paramName, param);
		template.delete(getURI(service, paramName), map);
	}
	
	private String getURI(final String service) {
		return prefix.concat(service);
	}
	
	private String getURI(final String service, final String param) {
		final String obtained = "{".concat(param).concat("}");
		return prefix.concat(service).concat(obtained);
	}
}
