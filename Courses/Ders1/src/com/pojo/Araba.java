/**
 * 
 */
package com.pojo;

import javax.management.modelmbean.ModelMBean;

/**
 * @author selcuk
 *
 */
public class Araba {

	private String ad = "BMW";
	private String renk;
	private Integer maxhix = 300;
	private Integer agirlik = 2;

	public void islem() {

	}

	public Araba() {
		System.out.println("Ýlk çalýþan method");
		setRenk("SIYAH");

	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

	public Integer getMaxhix() {
		return maxhix;
	}

	public void setMaxhix(Integer maxhix) {
		this.maxhix = maxhix;
	}

	public Integer getAgirlik() {
		return agirlik;
	}

	public void setAgirlik(Integer agirlik) {
		this.agirlik = agirlik;
	}

	public static void main() {

	}

}
