package com.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

import com.enums.ADRESTIP;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.EnumType.STRING;

/**
 * Entity implementation class for Entity: Adres
 *
 */
@Entity
@Table(name = "Adres")
public class Adres implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "SEQADR")
	@SequenceGenerator(name = "SEQADR", sequenceName = "SEQADR", allocationSize = 1, initialValue = 1)
	private Long id;

	@Column(length = 2000, nullable = false)
	private String acikAdres;

	@Column(unique = true, nullable = false)
	private String email;

	@Enumerated(STRING)
	private ADRESTIP adresTip;

	private static final long serialVersionUID = 1L;

	public Adres() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcikAdres() {
		return this.acikAdres;
	}

	public void setAcikAdres(String acikAdres) {
		this.acikAdres = acikAdres;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ADRESTIP getAdresTip() {
		return adresTip;
	}

	public void setAdresTip(ADRESTIP adresTip) {
		this.adresTip = adresTip;
	}

	@Override
	public String toString() {
		return "Adres [id=" + id + ", acikAdres=" + acikAdres + ", email=" + email + ", adresTip=" + adresTip + "]";
	}

	
	
}
