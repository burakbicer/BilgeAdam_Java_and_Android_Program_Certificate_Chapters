package com.pojos;

import java.io.Serializable;
import java.util.Date;

public class Is implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firmaAdi;
	private String pozisyon;
	private String girisZamani;
	private String cikisZamani;

	public Is(String firmaAdi, String pozisyon, String girisZamani, String cikisZamani) {
		super();
		this.firmaAdi = firmaAdi;
		this.pozisyon = pozisyon;
		this.girisZamani = girisZamani;
		this.cikisZamani = cikisZamani;
	}

	public String getFirmaAdi() {
		return firmaAdi;
	}

	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	public String getPozisyon() {
		return pozisyon;
	}

	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}

	public String getGirisZamani() {
		return girisZamani;
	}

	public void setGirisZamani(String girisZamani) {
		this.girisZamani = girisZamani;
	}

	public String getCikisZamani() {
		return cikisZamani;
	}

	public void setCikisZamani(String cikisZamani) {
		this.cikisZamani = cikisZamani;
	}

}
