package com.entities;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.enums.ISLEMTIP;

import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Kisi
 *
 */
@Entity
@Table(name = "Kisi", schema = "ORMDERS1")
@NamedQueries({ @NamedQuery(name = "Kisi.findAll", query = "select k from Kisi k"),

		@NamedQuery(name = "Kisi.findById", query = "select k from Kisi k where k.id = :kid"),
		@NamedQuery(name = "Kisi.findAllData", query = "select k from Kisi k join fetch k.isListesi join fetch k.adresBilgileri join fetch k.egitimListesi") })
public class Kisi extends BaseEntity implements Serializable {

	@Column(nullable = false)
	private String ad;

	@Column(nullable = false)
	private String soyad;

	@Column(unique = true, nullable = false)
	private String tc;

	@JoinTable(joinColumns = @JoinColumn(name = "Kisi_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "adresBilgileri_id", referencedColumnName = "id"))
	@OneToMany(cascade = { DETACH, REFRESH, REMOVE, PERSIST, MERGE }, fetch = FetchType.LAZY)
	private List<Adres> adresBilgileri = new ArrayList<>();

	@JoinTable(joinColumns = @JoinColumn(name = "Kisi_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "egitimListesi_id", referencedColumnName = "id"))
	@OneToMany(cascade = { DETACH, REFRESH, REMOVE, PERSIST, MERGE }, fetch = FetchType.LAZY)
	private List<Egitim> egitimListesi = new ArrayList<>();

	@OneToMany(cascade = ALL, fetch=FetchType.LAZY)
	@JoinTable(joinColumns = @JoinColumn(name = "Kisi_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "isListesi_id", referencedColumnName = "id"))
	private List<Meslek> isListesi = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	public Kisi() {
		super();
	}

	public String getAd() {
		return this.ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return this.soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTc() {
		return this.tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public List<Adres> getAdresBilgileri() {
		return adresBilgileri;
	}

	public void setAdresBilgileri(List<Adres> adresBilgileri) {
		this.adresBilgileri = adresBilgileri;
	}

	public List<Egitim> getEgitimListesi() {
		return egitimListesi;
	}

	public void setEgitimListesi(List<Egitim> egitimListesi) {
		this.egitimListesi = egitimListesi;
	}

	public List<Meslek> getIsListesi() {
		return isListesi;
	}

	public void setIsListesi(List<Meslek> isListesi) {
		this.isListesi = isListesi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ad == null) ? 0 : ad.hashCode());
		result = prime * result + ((adresBilgileri == null) ? 0 : adresBilgileri.hashCode());
		result = prime * result + ((egitimListesi == null) ? 0 : egitimListesi.hashCode());
		result = prime * result + ((isListesi == null) ? 0 : isListesi.hashCode());
		result = prime * result + ((soyad == null) ? 0 : soyad.hashCode());
		result = prime * result + ((tc == null) ? 0 : tc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kisi other = (Kisi) obj;
		if (ad == null) {
			if (other.ad != null)
				return false;
		} else if (!ad.equals(other.ad))
			return false;
		if (adresBilgileri == null) {
			if (other.adresBilgileri != null)
				return false;
		} else if (!adresBilgileri.equals(other.adresBilgileri))
			return false;
		if (egitimListesi == null) {
			if (other.egitimListesi != null)
				return false;
		} else if (!egitimListesi.equals(other.egitimListesi))
			return false;
		if (isListesi == null) {
			if (other.isListesi != null)
				return false;
		} else if (!isListesi.equals(other.isListesi))
			return false;
		if (soyad == null) {
			if (other.soyad != null)
				return false;
		} else if (!soyad.equals(other.soyad))
			return false;
		if (tc == null) {
			if (other.tc != null)
				return false;
		} else if (!tc.equals(other.tc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kisi [ad=" + ad + ", soyad=" + soyad + ", tc=" + tc + ", adresBilgileri=" + adresBilgileri
				+ ", egitimListesi=" + egitimListesi + ", isListesi=" + isListesi + "]";
	}
	

	@PrePersist
	private void kayittanOnce() {
		 
		System.out.println("Ki�i Kay�ttan �nce");		
	}
	
	@PostPersist
	private void kayittanSonra() {
		
		new LogTable()
		.setIslemTip(ISLEMTIP.CREATE)
		.setSinifAdi(this.getClass().getName())
		.done();
		
		System.out.println("Kay�ttan Sonra");
	}
	
	@PreUpdate
	private void guncellemedenOnce() {
		System.out.println("G�ncellemeden �nce !");
	}
	
	@PostUpdate
	private void guncellediktenSonra(){
		new LogTable()
		.setIslemTip(ISLEMTIP.UPDATE)
		.setSinifAdi(this.getClass().getName())
		.done();
		System.out.println("G�ncelledikten Sonra !");
	}
	
	@PreRemove
	private void silmedenOnce() {
		System.out.println("Silmeden �nce");
	}
	
	@PostRemove
	private void sildiktenSonra() {
		System.out.println("Sildikten Sonra !");
		new LogTable()
		.setIslemTip(ISLEMTIP.DELETE)
		.setSinifAdi(this.getClass().getName())
		.done();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	

}
