package com.daos;

import java.io.FileNotFoundException;

/**
 * Ortak DAO tan�mlamas� i�in yarat�lm��t�r.
 * 
 * @author selcuk
 *
 * @param <T> Varl�klar� parametre olarak g�nder
 */
public interface BaseDAO<T> {

	public boolean create(T varlik) ;

	public T read(Long id);

	public boolean update(T varlik, Long id);

	public boolean update(T varlik);

	public boolean delete(Long id);

	public boolean delete(T varlik);

	public default void senKimsin(T varlik) {
		System.out.println("S�n�f Bilgisi:" 
	+ ((Class) varlik).getName());
	}

}
