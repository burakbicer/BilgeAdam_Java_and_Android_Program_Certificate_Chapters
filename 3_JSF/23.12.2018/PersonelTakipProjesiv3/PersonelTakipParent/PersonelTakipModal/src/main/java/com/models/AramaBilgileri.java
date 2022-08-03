package com.models;

import java.io.Serializable;

public class AramaBilgileri implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ad="";
	private String soyad="";
	private Integer tc;

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Integer getTc() {
		return tc;
	}

	public void setTc(Integer tc) {
		this.tc = tc;
	}

	@Override
	public String toString() {
		return "AramaBilgileri [ad=" + ad + ", soyad=" + soyad + ", tc=" + tc + "]";
	}
	
	
	

}
