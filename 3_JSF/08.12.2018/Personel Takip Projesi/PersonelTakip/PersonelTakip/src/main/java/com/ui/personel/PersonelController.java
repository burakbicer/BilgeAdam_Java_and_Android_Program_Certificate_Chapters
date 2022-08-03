package com.ui.personel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.models.personel.Birim;

@ManagedBean
@ViewScoped
public class PersonelController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Birim> birimListesi = new ArrayList<>();

	private Integer secilenBirim = 0;
	private Integer secilenCinsiyet = 0;

	@PostConstruct
	private void init() {

		birimListesi.add(new Birim("Mühendislik", 1));
		birimListesi.add(new Birim("Ar-Ge", 2));
		birimListesi.add(new Birim("Ür-Ge", 3));
		birimListesi.add(new Birim("Delivery", 4));

	}

	public List<Birim> getBirimListesi() {
		return birimListesi;
	}

	public void setBirimListesi(List<Birim> birimListesi) {
		this.birimListesi = birimListesi;
	}

	public Integer getSecilenBirim() {
		return secilenBirim;
	}

	public void setSecilenBirim(Integer secilenBirim) {
		this.secilenBirim = secilenBirim;
	}

	public Integer getSecilenCinsiyet() {
		return secilenCinsiyet;
	}

	public void setSecilenCinsiyet(Integer secilenCinsiyet) {
		this.secilenCinsiyet = secilenCinsiyet;
	}

}
