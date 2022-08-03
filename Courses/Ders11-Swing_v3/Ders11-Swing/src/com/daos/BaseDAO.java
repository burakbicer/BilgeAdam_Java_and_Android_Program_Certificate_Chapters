package com.daos;

import java.io.FileNotFoundException;

/**
 * Ortak DAO tanýmlamasý için yaratýlmýþtýr.
 * 
 * @author selcuk
 *
 * @param <T> Varlýklarý parametre olarak gönder
 */
public interface BaseDAO<T> {

	public boolean create(T varlik) ;

	public T read(Long id);

	public boolean update(T varlik, Long id);

	public boolean update(T varlik);

	public boolean delete(Long id);

	public boolean delete(T varlik);

	public default void senKimsin(T varlik) {
		System.out.println("Sýnýf Bilgisi:" 
	+ ((Class) varlik).getName());
	}

}
