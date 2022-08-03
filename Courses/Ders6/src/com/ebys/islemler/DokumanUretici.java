package com.ebys.islemler;

import com.ebys.Belge;

public class DokumanUretici<T extends Belge> {

	private T dokuman;

	public T getDokuman() {
		return dokuman;
	}

	public void setDokuman(T dokuman) {
		this.dokuman = dokuman;
	}

}
