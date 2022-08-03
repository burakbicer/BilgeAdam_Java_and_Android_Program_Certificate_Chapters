package com.ebys.islemler;

import com.ebys.Belge;
import com.ebys.GelenEvrak;
import com.ebys.GidenEvrak;
import com.ebys.IcYazisma;

public class DokumanUreticisi2<T extends Belge> {

	private T evrak;

	public DokumanUreticisi2 dokumanYarat() {

		if (evrak instanceof GelenEvrak) {
			evrak = (T) new GelenEvrak();
		} else if (evrak instanceof GidenEvrak) {
			evrak = (T) new GidenEvrak();
		} else {
			evrak = (T) new IcYazisma();
		}
		return this;
	}

	public T getEvrak() {
		return evrak;
	}

	public void setEvrak(T evrak) {
		this.evrak = evrak;
	}

}
