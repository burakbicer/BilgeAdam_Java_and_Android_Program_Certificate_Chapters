package com.ust;

public class UstYonetim  {

	private Integer yonetimKati = 12;

	private String yonetimKurulu = "Ba�kanl�k";

	public UstYonetim() {
		super();
		System.out.println("�st Y�netim Kurucu S�n�f�");
	}

	public void islem() {
		 System.out.println("�st Y�netim ��lemi");
	}
	
	public UstYonetim(Integer yonetimKati, String yonetimKurulu) {
		this.yonetimKati = yonetimKati;
		this.yonetimKurulu = yonetimKurulu;
	}

	public Integer getYonetimKati() {
		return yonetimKati;
	}

	public void setYonetimKati(Integer yonetimKati) {
		this.yonetimKati = yonetimKati;
	}

	public String getYonetimKurulu() {
		return yonetimKurulu;
	}

	public void setYonetimKurulu(String yonetimKurulu) {
		this.yonetimKurulu = yonetimKurulu;
	}

}
