package com.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TUMUNI database table.
 * 
 */
@Entity  
@NamedQuery(name="Tumuni.findAll", query="SELECT t FROM Tumuni t")
public class Tumuni extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
 
	private String adres;

	private String birimadi;

	private String eposta;

	private String faks;

	private String internetadresi;

	private String rektorad;

	private String rektorsoyad;

	private String telefon;

	public Tumuni() {
	}

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getBirimadi() {
		return this.birimadi;
	}

	public void setBirimadi(String birimadi) {
		this.birimadi = birimadi;
	}

	public String getEposta() {
		return this.eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getFaks() {
		return this.faks;
	}

	public void setFaks(String faks) {
		this.faks = faks;
	}

	public String getInternetadresi() {
		return this.internetadresi;
	}

	public void setInternetadresi(String internetadresi) {
		this.internetadresi = internetadresi;
	}

	public String getRektorad() {
		return this.rektorad;
	}

	public void setRektorad(String rektorad) {
		this.rektorad = rektorad;
	}

	public String getRektorsoyad() {
		return this.rektorsoyad;
	}

	public void setRektorsoyad(String rektorsoyad) {
		this.rektorsoyad = rektorsoyad;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}