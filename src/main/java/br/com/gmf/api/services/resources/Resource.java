package br.com.gmf.api.services.resources;

import java.util.List;

public interface Resource<E, K> {

	List<E> get();
	E get(final K key);
	E post(final E entity);
	E put(final E entity);
	E delete(final E entity);
}
