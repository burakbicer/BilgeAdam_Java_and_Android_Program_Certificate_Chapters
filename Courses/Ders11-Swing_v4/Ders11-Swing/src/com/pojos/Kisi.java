package com.pojos;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import com.enums.Cinsiyet;

//Pojo: Form daki bilgileri tutacak olan objem. 
public class Kisi implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ad;
	private String soyad;
	private String tc;
	private Cinsiyet cinsiyet;
	private List<String> hobiler = new ArrayList<>();
	private Boolean sigaraKullanimi = false;
	private String adres;
	private List<Okul> okulBilgileri = new ArrayList<>();

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

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public Cinsiyet getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(Cinsiyet cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public List<String> getHobiler() {
		return hobiler;
	}

	public void setHobiler(List<String> hobiler) {
		this.hobiler = hobiler;
	}

	public Boolean getSigaraKullanimi() {
		return sigaraKullanimi;
	}

	public void setSigaraKullanimi(Boolean sigaraKullanimi) {
		this.sigaraKullanimi = sigaraKullanimi;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public List<Okul> getOkulBilgileri() {
		return okulBilgileri;
	}

	public void setOkulBilgileri(List<Okul> okulBilgileri) {
		this.okulBilgileri = okulBilgileri;
	}

}
