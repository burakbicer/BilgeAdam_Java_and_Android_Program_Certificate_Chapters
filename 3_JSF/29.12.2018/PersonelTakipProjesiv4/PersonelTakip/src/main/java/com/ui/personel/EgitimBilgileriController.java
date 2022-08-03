package com.ui.personel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.models.Tumuni;
import com.service.TumUniSERVICE;

@ManagedBean
@SessionScoped
public class EgitimBilgileriController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{personelController}")
	private PersonelController personelController;

	private List<Tumuni> tumUniListesi = new ArrayList<>();

	private Tumuni secilenUniversite;

	@PostConstruct
	private void init() {
		tumUniListesi = new TumUniSERVICE().universiteleriGetir();
	}

	public EgitimBilgileriController() {
		// TODO Auto-generated constructor stub
	}

	public PersonelController getPersonelController() {
		return personelController;
	}

	public void setPersonelController(PersonelController personelController) {
		this.personelController = personelController;
	}

	public List<Tumuni> getTumUniListesi() {
		return tumUniListesi;
	}

	public void setTumUniListesi(List<Tumuni> tumUniListesi) {
		this.tumUniListesi = tumUniListesi;
	}

	public Tumuni getSecilenUniversite() {
		return secilenUniversite;
	}

	public void setSecilenUniversite(Tumuni secilenUniversite) {
		this.secilenUniversite = secilenUniversite;
	}

	public void deneme() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",secilenUniversite.getBirimadi() ));
		
	}
	
	public Tumuni uniGetir(Long id) {
		
		if(id == null) {
			throw new IllegalArgumentException("ID bilgisi yok");
		}
		 
		return tumUniListesi.stream()
				.filter(uni -> id.equals(uni.getId()))
				.findAny()
				.orElse(null);
		
	}
	
	
}
