package com.ders4.hatalar;

public class OzelHata extends Exception {

	private double ihtiyacDuyulanMiktar;

	public OzelHata(double maasin) {

		this.ihtiyacDuyulanMiktar = maasin;

	}

	public double getMaas() {
		return ihtiyacDuyulanMiktar;
	}

}
