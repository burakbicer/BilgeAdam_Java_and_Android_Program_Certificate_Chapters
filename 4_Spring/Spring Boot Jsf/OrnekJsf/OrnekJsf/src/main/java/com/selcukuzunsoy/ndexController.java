package com.selcukuzunsoy;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@ManagedBean
@Scope(value = "session")
@Controller(value = "ndexController")
public class ndexController {

	private String ad;

	public void kaydet() {

		System.out.println("Bilgi geldi !:"+ad);

	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

}