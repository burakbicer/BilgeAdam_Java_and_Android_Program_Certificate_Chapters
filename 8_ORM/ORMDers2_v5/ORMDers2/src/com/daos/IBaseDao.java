package com.daos;

public interface IBaseDao<T> {

	public void create(T entity);

	public T read(Long id);

	public void update(T entity);

	public void delete(T entity);

	public void deleteSoft(T entity);
}
