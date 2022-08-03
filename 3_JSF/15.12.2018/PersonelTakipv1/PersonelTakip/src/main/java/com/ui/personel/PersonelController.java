package com.ui.personel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext; 

import com.models.Birim;
import com.models.Personel;
import com.service.PersonelSERVICE;

@ManagedBean
@RequestScoped
public class PersonelController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Birim> birimListesi = new ArrayList<>();

	private Integer secilenBirim = 0;
	private Integer secilenCinsiyet = 0;
	private String ad;
	private String soyad;
	private Integer tc;
	private Calendar dtarihi;

	@PostConstruct
	private void init() {

		birimListesi.add(new Birim("Mühendislik", 1));
		birimListesi.add(new Birim("Ar-Ge", 2));
		birimListesi.add(new Birim("Ür-Ge", 3));
		birimListesi.add(new Birim("Delivery", 4));

	}

	public void kaydet() {

		try {

			Personel per = new Personel();
			per.setAd(ad);
			per.setSoyad(soyad);
			per.setTc(tc);
			new PersonelSERVICE().create(per);
			FacesContext.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info","Ýþlem Baþarýlý !"));	
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal",e.getMessage()));
		}

	}

	public List<Birim> getBirimListesi() {
		return birimListesi;
	}

	public void setBirimListesi(List<Birim> birimListesi) {
		this.birimListesi = birimListesi;
	}

	public Integer getSecilenBirim() {
		return secilenBirim;
	}

	public void setSecilenBirim(Integer secilenBirim) {
		this.secilenBirim = secilenBirim;
	}

	public Integer getSecilenCinsiyet() {
		return secilenCinsiyet;
	}

	public void setSecilenCinsiyet(Integer secilenCinsiyet) {
		this.secilenCinsiyet = secilenCinsiyet;
	}

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

	public Calendar getDtarihi() {
		return dtarihi;
	}

	public void setDtarihi(Calendar dtarihi) {
		this.dtarihi = dtarihi;
	}

}
