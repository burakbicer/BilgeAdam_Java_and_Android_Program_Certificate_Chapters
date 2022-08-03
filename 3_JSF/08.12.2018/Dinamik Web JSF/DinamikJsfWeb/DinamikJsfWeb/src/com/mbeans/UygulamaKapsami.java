package com.mbeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="uygulamaKapsami")
@ApplicationScoped
public class UygulamaKapsami implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer oturumAdedi = 0;

	public Integer getOturumAdedi() {
		return oturumAdedi;
	}

	public void setOturumAdedi(Integer oturumAdedi) {
		this.oturumAdedi = oturumAdedi;
	}
	
	
	
	
}
