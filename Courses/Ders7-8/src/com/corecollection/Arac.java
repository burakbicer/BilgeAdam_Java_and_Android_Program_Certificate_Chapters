package com.corecollection;

import java.util.Comparator;

public  class Arac implements Comparable<Arac> {

	private String aracAdi;
	private String aracModel;
	private Integer fiyat;

	public Arac(String aracAdi, String aracModel, Integer fiyat) {
		super();
		this.aracAdi = aracAdi;
		this.aracModel = aracModel;
		this.fiyat = fiyat;
	}

	public String getAracAdi() {
		return aracAdi;
	}

	public void setAracAdi(String aracAdi) {
		this.aracAdi = aracAdi;
	}

	public String getAracModel() {
		return aracModel;
	}

	public void setAracModel(String aracModel) {
		this.aracModel = aracModel;
	}

	public Integer getFiyat() {
		return fiyat;
	}

	public void setFiyat(Integer fiyat) {
		this.fiyat = fiyat;
	}

	@Override
	public int compareTo(Arac o) {
		
		return o.getFiyat()- this.fiyat;
	}
	
	
	public static Comparator<Arac> ismeGoreListeleComp 
	= new Comparator<Arac>() {

		@Override
		public int compare(Arac o1, Arac o2) {
			String aracAdi1 = o1.aracAdi.toUpperCase();
			String aracAdi2 = o2.aracAdi.toUpperCase();
			return aracAdi2.compareTo(aracAdi1);
		}		
	};
	
	
	
	
	
	

}
