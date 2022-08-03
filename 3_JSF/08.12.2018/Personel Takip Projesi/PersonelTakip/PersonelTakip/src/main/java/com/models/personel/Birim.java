package com.models.personel;

import java.io.Serializable;

public class Birim implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String birimAdi;
	private Integer birimId;

	public Birim(String birimAdi, Integer birimId) {
		super();
		this.birimAdi = birimAdi;
		this.birimId = birimId;
	}

	public String getBirimAdi() {
		return birimAdi;
	}

	public void setBirimAdi(String birimAdi) {
		this.birimAdi = birimAdi;
	}

	public Integer getBirimId() {
		return birimId;
	}

	public void setBirimId(Integer birimId) {
		this.birimId = birimId;
	}

}
