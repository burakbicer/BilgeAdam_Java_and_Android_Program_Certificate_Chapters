package com.pojos.arac;

import com.pojos.Arac;

public class Mercedes extends Arac {

	private Boolean aktifFar = false;
	private Boolean startStop = false;
	private Boolean f1Vites = false;

	public Mercedes() {

	}

	@Override
	public void motoruCalistir() {
		super.motoruCalistir();
		farlariYak();
	}

	@Override
	public void aracMarkasi() {
		System.out.println("Mercedes");
	}

	public Boolean getAktifFar() {
		return aktifFar;
	}

	public void setAktifFar(Boolean aktifFar) {
		this.aktifFar = aktifFar;
	}

	public Boolean getStartStop() {
		return startStop;
	}

	public void setStartStop(Boolean startStop) {
		this.startStop = startStop;
	}

	public Boolean getF1Vites() {
		return f1Vites;
	}

	public void setF1Vites(Boolean f1Vites) {
		this.f1Vites = f1Vites;
	}

}
