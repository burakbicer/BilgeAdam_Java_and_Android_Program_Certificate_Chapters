package com.oop;

public class Arac implements IMethodlar {

	private String ad;
	private String model;

	@Override
	public void camiAc() {
		System.out.println("Camý Aç Çalýþtý");
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
