package com.ui.personel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.daos.PersonelTakipHata;
import com.models.Birim;
import com.models.Personel;
import com.service.BirimSERVICE;
import com.service.PersonelSERVICE;

@ManagedBean
@SessionScoped
public class PersonelController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Birim> birimListesi = new ArrayList<>();
	private List<Personel> personelListesi = new ArrayList<>();
	private Personel secilenPersonel;

	private Long secilenBirim = 0L;
	private Integer secilenCinsiyet = 1;
	private String ad;
	private String soyad;
	private Integer tc;
	private Calendar dtarihi;

	@PostConstruct
	private void init() {
		/*
		 * try{ new BirimSERVICE().create(new Birim("Mühendislik", 1)); new
		 * BirimSERVICE().create(new Birim("Ar-Ge", 2)); new BirimSERVICE().create(new
		 * Birim("Ür-Ge", 3)); new BirimSERVICE().create(new Birim("Delivery", 4));
		 * 
		 * } catch (PersonelTakipHata e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */

		try {
			birimListesi = new BirimSERVICE().birimListesiGetir();
			personelListesi = new PersonelSERVICE().personelListesiGetir();
		} catch (PersonelTakipHata e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void satirSec(SelectEvent secilen) {
		ad = ((Personel) secilen.getObject()).getAd();
		soyad = ((Personel) secilen.getObject()).getSoyad();
		tc = ((Personel) secilen.getObject()).getTc();
		dtarihi = ((Personel) secilen.getObject()).getDtarihi();
		secilenCinsiyet = ((Personel) secilen.getObject()).getCinsiyet();
		secilenBirim = ((Personel) secilen.getObject()).getBirim().getId();
	}

	public void kaydet() {

		try {
			if(secilenPersonel==null) {
			
			Personel per = new Personel();
			per.setAd(ad);
			per.setSoyad(soyad);
			per.setTc(tc);
			per.setCinsiyet(secilenCinsiyet);
			per.setDtarihi(dtarihi);
			per.setBirim(new BirimSERVICE().read(secilenBirim));

			new PersonelSERVICE().create(per);
			
			}else {
				
			Personel per = secilenPersonel;
			per.setAd(ad);
			per.setSoyad(soyad);
			per.setTc(tc);
			per.setCinsiyet(secilenCinsiyet);
			per.setDtarihi(dtarihi);
			per.setBirim(new BirimSERVICE().read(secilenBirim));
			
			new PersonelSERVICE().update(per);
			
			}
			 
			yeni();
			personelListesi = new PersonelSERVICE().personelListesiGetir();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Ýþlem Baþarýlý !"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal", e.getMessage()));
		}

	}

	public void yeni() {

		ad = "";
		soyad = "";
		tc = null;
		dtarihi = null;
		secilenCinsiyet = 1;
		secilenBirim = null;

	}

	public void sil() {
		
		try {
			new PersonelSERVICE().delete(secilenPersonel);
			personelListesi = new PersonelSERVICE().personelListesiGetir();
			yeni();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Ýþlem Baþarýlý !"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal", e.getMessage()));
		}

	}

	public List<Birim> getBirimListesi() {
		return birimListesi;
	}

	public void setBirimListesi(List<Birim> birimListesi) {
		this.birimListesi = birimListesi;
	}

	public Long getSecilenBirim() {
		return secilenBirim;
	}

	public void setSecilenBirim(Long secilenBirim) {
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

	public List<Personel> getPersonelListesi() {
		return personelListesi;
	}

	public void setPersonelListesi(List<Personel> personelListesi) {
		this.personelListesi = personelListesi;
	}

	public Personel getSecilenPersonel() {
		return secilenPersonel;
	}

	public void setSecilenPersonel(Personel secilenPersonel) {
		this.secilenPersonel = secilenPersonel;
	}

}
