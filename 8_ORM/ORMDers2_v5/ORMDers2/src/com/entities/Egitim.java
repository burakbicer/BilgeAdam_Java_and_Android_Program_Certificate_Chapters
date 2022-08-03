package com.entities;

import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 * Entity implementation class for Entity: Egitim
 *
 */
@Entity
public class Egitim extends BaseEntity implements Serializable {

	private String OkulAdi;

	private String Bolum;

	@Temporal(DATE)
	private Calendar girisTarihi;

	@Temporal(DATE)
	private Calendar mezuniyetTarihi;

	private Boolean mezun = false;

	private static final long serialVersionUID = 1L;

	public Egitim() {
		super();
	}

	public String getOkulAdi() {
		return this.OkulAdi;
	}

	public void setOkulAdi(String OkulAdi) {
		this.OkulAdi = OkulAdi;
	}

	public String getBolum() {
		return this.Bolum;
	}

	public void setBolum(String Bolum) {
		this.Bolum = Bolum;
	}

	public Calendar getGirisTarihi() {
		return this.girisTarihi;
	}

	public void setGirisTarihi(Calendar girisTarihi) {
		this.girisTarihi = girisTarihi;
	}

	public Calendar getMezuniyetTarihi() {
		return this.mezuniyetTarihi;
	}

	public void setMezuniyetTarihi(Calendar mezuniyetTarihi) {
		this.mezuniyetTarihi = mezuniyetTarihi;
	}

	public Boolean getMezun() {
		return this.mezun;
	}

	public void setMezun(Boolean mezun) {
		this.mezun = mezun;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Bolum == null) ? 0 : Bolum.hashCode());
		result = prime * result + ((OkulAdi == null) ? 0 : OkulAdi.hashCode());
		result = prime * result + ((girisTarihi == null) ? 0 : girisTarihi.hashCode());
		result = prime * result + ((mezun == null) ? 0 : mezun.hashCode());
		result = prime * result + ((mezuniyetTarihi == null) ? 0 : mezuniyetTarihi.hashCode());
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
		Egitim other = (Egitim) obj;
		if (Bolum == null) {
			if (other.Bolum != null)
				return false;
		} else if (!Bolum.equals(other.Bolum))
			return false;
		if (OkulAdi == null) {
			if (other.OkulAdi != null)
				return false;
		} else if (!OkulAdi.equals(other.OkulAdi))
			return false;
		if (girisTarihi == null) {
			if (other.girisTarihi != null)
				return false;
		} else if (!girisTarihi.equals(other.girisTarihi))
			return false;
		if (mezun == null) {
			if (other.mezun != null)
				return false;
		} else if (!mezun.equals(other.mezun))
			return false;
		if (mezuniyetTarihi == null) {
			if (other.mezuniyetTarihi != null)
				return false;
		} else if (!mezuniyetTarihi.equals(other.mezuniyetTarihi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Egitim [OkulAdi=" + OkulAdi + ", Bolum=" + Bolum + ", girisTarihi=" + girisTarihi + ", mezuniyetTarihi="
				+ mezuniyetTarihi + ", mezun=" + mezun + "]";
	}

}
