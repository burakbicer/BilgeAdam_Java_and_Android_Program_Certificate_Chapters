package com.pojos.afp;

public class AracFabrikasiYoneticisi {

	private AracFabrikasi<Arac> aracFabrikasi;

	public AracFabrikasiYoneticisi(Arac arac) {

		setAracFabrikasi(new AracFabrikasi<>());
		getAracFabrikasi().setArac(arac);

	}

	public AracFabrikasi<Arac> getAracFabrikasi() {
		return aracFabrikasi;
	}

	public void setAracFabrikasi(AracFabrikasi<Arac> aracFabrikasi) {
		this.aracFabrikasi = aracFabrikasi;
	}

}
