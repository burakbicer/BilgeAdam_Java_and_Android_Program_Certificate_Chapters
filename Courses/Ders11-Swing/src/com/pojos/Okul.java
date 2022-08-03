package com.pojos;

import java.io.Serializable;

public class Okul implements Serializable {

	private static final long serialVersionUID = 1L;

	private String okulAdi;
	private String bolumAdi;
	private Double gpu;

	public Okul(String okulAdi, String bolumAdi, Double gpu) {
		super();
		this.okulAdi = okulAdi;
		this.bolumAdi = bolumAdi;
		this.gpu = gpu;
	}

	public String getOkulAdi() {
		return okulAdi;
	}

	public void setOkulAdi(String okulAdi) {
		this.okulAdi = okulAdi;
	}

	public String getBolumAdi() {
		return bolumAdi;
	}

	public void setBolumAdi(String bolumAdi) {
		this.bolumAdi = bolumAdi;
	}

	public Double getGpu() {
		return gpu;
	}

	public void setGpu(Double gpu) {
		this.gpu = gpu;
	}

}
