package com.ui.ara;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.models.AramaBilgileri;
import com.models.Personel;
import com.service.AramaSERVICE;
import com.ui.personel.PersonelController;

@ManagedBean
@SessionScoped
public class AramaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{personelController}")
	PersonelController personelController;

	private List<Personel> arananPersoneller = new ArrayList<>();

	private Personel secilenPersonel;

	private AramaBilgileri aramaBilgileri = new AramaBilgileri();

	@PostConstruct
	private void init() {

	}

	public void ara() {

		System.out.println("Bilgiler:" + aramaBilgileri);

		arananPersoneller = new AramaSERVICE().ara(aramaBilgileri);

	}

	public String personeliDuzenle(Personel personel) {

		personelController.setSecilenPersonel(personel);
		personelController.setAd(personel.getAd());
		personelController.setSoyad(personel.getSoyad());
		personelController.setTc(personel.getTc());
		personelController.setDtarihi(personel.getDtarihi());
		personelController.setSecilenCinsiyet(personel.getCinsiyet());
		personelController.setSecilenBirim(personel.getBirim().getId());
		
		return "index";
	}

	public List<Personel> getArananPersoneller() {
		return arananPersoneller;
	}

	public void setArananPersoneller(List<Personel> arananPersoneller) {
		this.arananPersoneller = arananPersoneller;
	}

	public Personel getSecilenPersonel() {
		return secilenPersonel;
	}

	public void setSecilenPersonel(Personel secilenPersonel) {
		this.secilenPersonel = secilenPersonel;
	}

	public AramaBilgileri getAramaBilgileri() {
		return aramaBilgileri;
	}

	public void setAramaBilgileri(AramaBilgileri aramaBilgileri) {
		this.aramaBilgileri = aramaBilgileri;
	}

	public PersonelController getPersonelController() {
		return personelController;
	}

	public void setPersonelController(PersonelController personelController) {
		this.personelController = personelController;
	}

}
