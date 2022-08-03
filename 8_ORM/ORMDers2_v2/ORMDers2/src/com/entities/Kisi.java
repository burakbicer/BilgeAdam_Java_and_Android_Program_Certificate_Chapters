package com.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.LockModeType.OPTIMISTIC;

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

}
