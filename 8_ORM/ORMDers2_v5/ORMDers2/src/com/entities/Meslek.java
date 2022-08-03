package com.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.enums.ISTIP;

/**
 * Entity implementation class for Entity: Is
 *
 */
@Entity
public class Meslek extends BaseEntity implements Serializable {

	private String firmaAdi;

	private String pozisyonAdi;

	@Temporal(TemporalType.DATE)
	private Calendar girisTarihi;

	@Temporal(TemporalType.DATE)
	private Calendar cikisTarihi;

	@Column(length = 2000)
	private String gorevTanimi;

	@Enumerated(EnumType.STRING)
	private ISTIP isTip;

	private static final long serialVersionUID = 1L;

	public Meslek() {
		super();
	}

	public String getFirmaAdi() {
		return this.firmaAdi;
	}

	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	public String getPozisyonAdi() {
		return this.pozisyonAdi;
	}

	public void setPozisyonAdi(String pozisyonAdi) {
		this.pozisyonAdi = pozisyonAdi;
	}

	public Calendar getGirisTarihi() {
		return this.girisTarihi;
	}

	public void setGirisTarihi(Calendar girisTarihi) {
		this.girisTarihi = girisTarihi;
	}

	public Calendar getCikisTarihi() {
		return this.cikisTarihi;
	}

	public void setCikisTarihi(Calendar cikisTarihi) {
		this.cikisTarihi = cikisTarihi;
	}

	public String getGorevTanimi() {
		return this.gorevTanimi;
	}

	public void setGorevTanimi(String gorevTanimi) {
		this.gorevTanimi = gorevTanimi;
	}

	public ISTIP getIsTip() {
		return isTip;
	}

	public void setIsTip(ISTIP isTip) {
		this.isTip = isTip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cikisTarihi == null) ? 0 : cikisTarihi.hashCode());
		result = prime * result + ((firmaAdi == null) ? 0 : firmaAdi.hashCode());
		result = prime * result + ((girisTarihi == null) ? 0 : girisTarihi.hashCode());
		result = prime * result + ((gorevTanimi == null) ? 0 : gorevTanimi.hashCode());
		result = prime * result + ((isTip == null) ? 0 : isTip.hashCode());
		result = prime * result + ((pozisyonAdi == null) ? 0 : pozisyonAdi.hashCode());
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
		Meslek other = (Meslek) obj;
		if (cikisTarihi == null) {
			if (other.cikisTarihi != null)
				return false;
		} else if (!cikisTarihi.equals(other.cikisTarihi))
			return false;
		if (firmaAdi == null) {
			if (other.firmaAdi != null)
				return false;
		} else if (!firmaAdi.equals(other.firmaAdi))
			return false;
		if (girisTarihi == null) {
			if (other.girisTarihi != null)
				return false;
		} else if (!girisTarihi.equals(other.girisTarihi))
			return false;
		if (gorevTanimi == null) {
			if (other.gorevTanimi != null)
				return false;
		} else if (!gorevTanimi.equals(other.gorevTanimi))
			return false;
		if (isTip != other.isTip)
			return false;
		if (pozisyonAdi == null) {
			if (other.pozisyonAdi != null)
				return false;
		} else if (!pozisyonAdi.equals(other.pozisyonAdi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meslek [firmaAdi=" + firmaAdi + ", pozisyonAdi=" + pozisyonAdi + ", girisTarihi=" + girisTarihi
				+ ", cikisTarihi=" + cikisTarihi + ", gorevTanimi=" + gorevTanimi + ", isTip=" + isTip + "]";
	}

}
