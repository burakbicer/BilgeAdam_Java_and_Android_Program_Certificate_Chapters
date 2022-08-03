package com.ders4.hatalar;

public class HesapKapali extends Exception {
 
	private boolean durum = false;

	public HesapKapali(boolean durum) {

		this.durum = durum;

	}

	public boolean isDurum() {
		return durum;
	}

}
