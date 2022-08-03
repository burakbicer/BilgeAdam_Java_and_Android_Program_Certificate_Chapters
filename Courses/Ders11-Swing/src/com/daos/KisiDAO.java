package com.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.pojos.Kisi;

public class KisiDAO implements BaseDAO<Kisi> {

	/**
	 * Kiþi varlýðýný kaydetmek için kullanýlýr.
	 */
	@Override
	public boolean create(Kisi varlik) {

		ObjectOutputStream oos = null;
		try {

			FileOutputStream fos = new FileOutputStream(new File("database.txt"));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(varlik);
			oos.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return false;
	}

	@Override
	public Kisi read(Long id) {

		try {

			FileInputStream fis = new FileInputStream(new File("database.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			Kisi kisi = (Kisi) ois.readObject();
			ois.close();
			return kisi;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean update(Kisi varlik, Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Kisi varlik) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Kisi varlik) {
		// TODO Auto-generated method stub
		return false;
	}

}
