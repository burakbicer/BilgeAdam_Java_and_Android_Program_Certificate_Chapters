package com.pojos.arac;

import com.pojos.Arac;
import com.pojos.DSG;

public class BMW extends Arac {

	private DSG dsgType;
	private Boolean koltukIsitma = false;

	public BMW() {
		setDsgType(DSG.YEDI);

	}

	@Override
	public void camiAc() {
		// TODO Auto-generated method stub
		super.camiAc();
		klimayiKapat();
	}

	@Override
	public void aracMarkasi() {
		System.out.println("Bmw");
	}

	public DSG getDsgType() {
		return dsgType;
	}

	public void setDsgType(DSG dsgType) {
		this.dsgType = dsgType;
	}

	public Boolean getKoltukIsitma() {
		return koltukIsitma;
	}

	public void setKoltukIsitma(Boolean koltukIsitma) {
		this.koltukIsitma = koltukIsitma;
	}

}
