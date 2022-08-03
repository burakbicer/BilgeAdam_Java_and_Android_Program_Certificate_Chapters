package com.service;

import com.daos.PersonelTakipHata;
import com.models.BaseEntity;

public interface IBaseService<T extends BaseEntity> {

	public void create(T entity) throws PersonelTakipHata;

	public T read(Long id) throws PersonelTakipHata;

	public void update(T entity) throws PersonelTakipHata;

	public void delete(T entity) throws PersonelTakipHata;

}
