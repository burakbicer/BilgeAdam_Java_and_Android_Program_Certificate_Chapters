package com.ebys;

import java.util.Date;

/**
 * Belge --Gelen Evrak --Giden Evrak --Ýç Yazýþma
 * 
 * 
 * 
 * 
 * 
 * @author selcuk
 *
 */

public class Belge {

	private String konu;
	private String makam;
	private Date olusmaTarihi;
	private Long no;

	public String getKonu() {
		return konu;
	}

	public void setKonu(String konu) {
		this.konu = konu;
	}

	public String getMakam() {
		return makam;
	}

	public void setMakam(String makam) {
		this.makam = makam;
	}

	public Date getOlusmaTarihi() {
		return olusmaTarihi;
	}

	public void setOlusmaTarihi(Date olusmaTarihi) {
		this.olusmaTarihi = olusmaTarihi;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

}
