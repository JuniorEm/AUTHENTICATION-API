package br.com.authentication.api.services.resources;

public interface Resource<E> {

	E get(final E entity);
	E post(final E entity);
	E put(final E entity);
	E delete(final E entity);
}
