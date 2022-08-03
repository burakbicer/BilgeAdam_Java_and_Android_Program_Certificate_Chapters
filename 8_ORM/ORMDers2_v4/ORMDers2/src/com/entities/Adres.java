package com.entities;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.enums.ADRESTIP;

/**
 * Entity implementation class for Entity: Adres
 *
 */
@Entity
@Table(name = "Adres") 
public class Adres extends BaseEntity implements Serializable {


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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((acikAdres == null) ? 0 : acikAdres.hashCode());
		result = prime * result + ((adresTip == null) ? 0 : adresTip.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Adres other = (Adres) obj;
		if (acikAdres == null) {
			if (other.acikAdres != null)
				return false;
		} else if (!acikAdres.equals(other.acikAdres))
			return false;
		if (adresTip != other.adresTip)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Adres [acikAdres=" + acikAdres + ", email=" + email + ", adresTip=" + adresTip + "]";
	}

 
	
}
