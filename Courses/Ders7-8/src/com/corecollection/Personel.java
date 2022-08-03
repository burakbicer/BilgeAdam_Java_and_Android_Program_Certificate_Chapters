package com.corecollection;

import java.util.Comparator;

public class Personel implements Comparable<Personel> {

	private String isim;
	private String soyisim;
	private Integer yas;
	private Integer maas;

	public Personel(String isim, String soyisim, Integer yas, Integer maas) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.yas = yas;
		this.maas = maas;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public Integer getYas() {
		return yas;
	}

	public void setYas(Integer yas) {
		this.yas = yas;
	}

	public Integer getMaas() {
		return maas;
	}

	public void setMaas(Integer maas) {
		this.maas = maas;
	}

	@Override
	public int compareTo(Personel o) {

		// Ascending order
		return getYas() - o.getYas();
	}

	public static Comparator<Personel> maasKiyaslaComp = new Comparator<Personel>() {

		@Override
		public int compare(Personel o1, Personel o2) {
			// Ascending order
			return o1.getMaas() - o2.getMaas();

		}

	};

}
