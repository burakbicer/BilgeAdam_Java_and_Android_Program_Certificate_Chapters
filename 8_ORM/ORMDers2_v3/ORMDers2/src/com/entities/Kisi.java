package com.entities;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import static javax.persistence.CascadeType.MERGE;

/**
 * Entity implementation class for Entity: Kisi
 *
 */
@Entity
@Table(name = "Kisi", schema = "ORMDERS1")
@NamedQueries({ @NamedQuery(name = "Kisi.findAll", query = "select k from Kisi k"),

		@NamedQuery(name = "Kisi.findById", query = "select k from Kisi k where k.id = :kid") })
public class Kisi implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "SEQKISI")
	@SequenceGenerator(name = "SEQKISI", allocationSize = 1, initialValue = 1, sequenceName = "SEQKISI")
	private long id;

	@Column(nullable = false)
	private String ad;

	@Column(nullable = false)
	private String soyad;

	@Column(unique = true, nullable = false)
	private String tc;

	@JoinTable(joinColumns = @JoinColumn(name = "Kisi_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "adresBilgileri_id", referencedColumnName = "id"))
	@OneToMany(cascade = { DETACH, REFRESH, REMOVE, PERSIST, MERGE }, fetch = EAGER)
	private List<Adres> adresBilgileri = new ArrayList<>();

	@JoinTable(joinColumns = @JoinColumn(name = "Kisi_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "egitimListesi_id", referencedColumnName = "id"))
	@OneToMany(cascade = { DETACH, REFRESH, REMOVE, PERSIST, MERGE }, fetch = EAGER)
	private List<Egitim> egitimListesi = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	public Kisi() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Kisi [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", tc=" + tc + ", adresBilgileri="
				+ adresBilgileri + ", egitimListesi=" + egitimListesi + "]";
	}

	 
}
