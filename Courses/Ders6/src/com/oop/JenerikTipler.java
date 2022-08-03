package com.oop;

public class JenerikTipler<T> {

	private T bilgi;

	public T getBilgi() {
		return bilgi;
	}

	public void setBilgi(T bilgi) {
		this.bilgi = bilgi;
	}

	public static void main(String[] args) {

		JenerikTipler<String> jt = new JenerikTipler<String>();
		jt.setBilgi("Selçuk");
		System.out.println("Deneme 1:" + jt.getBilgi());

		JenerikTipler<Integer> jt2 = new JenerikTipler<Integer>();
		jt2.setBilgi(30);
		System.out.println("Deneme 2:" + jt2.getBilgi());

		JenerikTipler<JenerikTipler<String>> jt3 = new JenerikTipler<>();
		jt3.setBilgi(jt);
		System.out.println("Deneme 3:" + jt3.getBilgi().getBilgi());
 
		new JenerikTipler<>().islem();
		
	}
	
	public void islem() {
		
		JenerikTipler<Araba>  jt = new JenerikTipler<JenerikTipler<T>.Araba>();
		jt.setBilgi(new Araba());
		jt.getBilgi().setAd("Bmw");
		jt.getBilgi().setModel("320i");
		jt.getBilgi().setUretimYili(2018);
		System.out.println("Bilgi:"+jt.getBilgi().getAd());
		
		
	}
	
	

	class Araba {

		private String ad;
		private String model;
		private Integer uretimYili;

		public String getAd() {
			return ad;
		}

		public void setAd(String ad) {
			this.ad = ad;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public Integer getUretimYili() {
			return uretimYili;
		}

		public void setUretimYili(Integer uretimYili) {
			this.uretimYili = uretimYili;
		}

	}

}
