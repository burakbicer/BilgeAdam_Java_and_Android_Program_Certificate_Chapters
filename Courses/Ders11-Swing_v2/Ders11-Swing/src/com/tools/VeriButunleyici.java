package com.tools;

import java.util.ArrayList;
import java.util.List;

import com.enums.Cinsiyet;
import com.forms.AnaEkran;
import com.pojos.Kisi;

public class VeriButunleyici {

	private Kisi kisi = new Kisi();

	public VeriButunleyici(Kisi kisi) {
		this.kisi = kisi;
	}

	public VeriButunleyici() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VeriButunleyici ready(AnaEkran anaEkran) {

		getKisi().setAd(anaEkran.getTxtAd().getText());
		getKisi().setSoyad(anaEkran.getTxtSoyad().getText());
		getKisi().setTc(anaEkran.getTxtTc().getText());
		getKisi().setCinsiyet(Cinsiyet.valueOf(anaEkran.getCmbCinsiyet().getSelectedItem().toString()));

		List<String> hobiler = new ArrayList<>();
		if (anaEkran.getChckbxAtclk().isSelected())
			hobiler.add("Atýcýlýk");
		if (anaEkran.getChckbxBinicilik().isSelected())
			hobiler.add("Binicilik");
		if (anaEkran.getChckbxYzme().isSelected())
			hobiler.add("Yüzme");

		getKisi().setHobiler(hobiler);

		getKisi().setSigaraKullanimi(anaEkran.getRdbtnEvet().isSelected());

		getKisi().setAdres(anaEkran.getTxtAdres().getText());
		return this;
	}

	public void formReady(AnaEkran anaEkran) {

		anaEkran.getTxtAd().setText(getKisi().getAd());
		anaEkran.getTxtSoyad().setText(getKisi().getSoyad());
		anaEkran.getTxtTc().setText(getKisi().getTc());
		anaEkran.getTxtAdres().setText(getKisi().getAdres());

		anaEkran.getCmbCinsiyet()
		.setSelectedItem(getKisi().getCinsiyet());
		
		if (getKisi().getHobiler().contains("Atýcýlýk"))
			anaEkran.getChckbxAtclk().setSelected(true);

		if (getKisi().getHobiler().contains("Binicilik"))
			anaEkran.getChckbxBinicilik().setSelected(true);

		if (getKisi().getHobiler().contains("Yüzme"))
			anaEkran.getChckbxYzme().setSelected(true);

		if (getKisi().getSigaraKullanimi()) {
			anaEkran.getRdbtnEvet().setSelected(true);
		} else {
			anaEkran.getRdbtnHayr().setSelected(true);
		}

	}

	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

}
