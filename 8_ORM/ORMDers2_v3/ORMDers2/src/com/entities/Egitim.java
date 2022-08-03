package com.entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.Calendar;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: Egitim
 *
 */
@Entity
public class Egitim implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "SEQEGI")
	@SequenceGenerator(name = "SEQEGI", allocationSize = 1, initialValue = 1, sequenceName = "SEQEGI")
	private Long id;
	
	private String OkulAdi;
	
	private String Bolum;
	
	@Temporal(DATE)
	private Calendar girisTarihi;
	
	@Temporal(DATE)
	private Calendar mezuniyetTarihi;
	
	private Boolean mezun= false;
	
	private static final long serialVersionUID = 1L;

	public Egitim() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public String toString() {
		return "Egitim [id=" + id + ", OkulAdi=" + OkulAdi + ", Bolum=" + Bolum + ", girisTarihi=" + girisTarihi
				+ ", mezuniyetTarihi=" + mezuniyetTarihi + ", mezun=" + mezun + "]";
	}
   
	
	
}
