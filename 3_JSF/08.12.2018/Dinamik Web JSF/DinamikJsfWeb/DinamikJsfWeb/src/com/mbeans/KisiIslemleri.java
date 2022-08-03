package com.mbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@SessionScoped
public class KisiIslemleri implements Serializable {

	@ManagedProperty(value="#{uygulamaKapsami}")
	private UygulamaKapsami uygulamaKapsami;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ad = "";

	private String soyad = "";
	private String tc = "";

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

	private void formuBosalt() {
		setAd("");
		setSoyad("");
		setTc("");
	}

	public UygulamaKapsami getUygulamaKapsami() {
		return uygulamaKapsami;
	}

	public void setUygulamaKapsami(UygulamaKapsami uygulamaKapsami) {
		this.uygulamaKapsami = uygulamaKapsami;
	}

	public String kisiKaydet() {

		System.out.println("Kiþi: Ad:" + ad + " Soyad:" + soyad + " Tc:" + tc);
		// formuBosalt();
		return "sonucgoster";
	}

}
