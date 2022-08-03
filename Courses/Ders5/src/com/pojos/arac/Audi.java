package com.pojos.arac;

import com.pojos.Arac;
import com.pojos.IAracAlarm;

public class Audi extends Arac implements IAracAlarm {

	private Boolean quadro = false;
	private Boolean cc = false;

	@Override
	public void farlariYak() {
		super.farlariYak();
		kapilariKitle();
	}

	@Override
	public void aracMarkasi() {
		System.out.println("Audi");
	}

	
	public Boolean getQuadro() {
		return quadro;
	}

	public void setQuadro(Boolean quadro) {
		this.quadro = quadro;
	}

	public Boolean getCc() {
		return cc;
	}

	public void setCc(Boolean cc) {
		this.cc = cc;
	}

}
