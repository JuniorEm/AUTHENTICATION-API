package br.com.gmf.api.services.resources;

public interface Resource<E, K> {

	E get();
	E get(final K key);
	E post(final E entity);
	E put(final E entity);
	E delete(final E entity);
}
