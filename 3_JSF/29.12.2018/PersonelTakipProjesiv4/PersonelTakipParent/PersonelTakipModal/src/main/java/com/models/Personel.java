package com.models;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Calendar;
import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: Personel
 *
 */
@Entity
public class Personel extends BaseEntity implements Serializable {

	@Column(length = 50)
	private String ad;

	@Column(length = 100)
	private String soyad;

	@Column(length = 11)
	private Integer tc;

	@Temporal(DATE)
	private Calendar dtarihi;

	private Integer cinsiyet;

	@OneToOne
	@JoinColumn(name = "fk_birim_id", referencedColumnName = "id")
	private Birim birim;

	private static final long serialVersionUID = 1L;

	public Personel() {
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

	public Integer getTc() {
		return this.tc;
	}

	public void setTc(Integer tc) {
		this.tc = tc;
	}

	public Calendar getDtarihi() {
		return this.dtarihi;
	}

	public void setDtarihi(Calendar dtarihi) {
		this.dtarihi = dtarihi;
	}

	public Integer getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(Integer cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public Birim getBirim() {
		return birim;
	}

	public void setBirim(Birim birim) {
		this.birim = birim;
	}

}
