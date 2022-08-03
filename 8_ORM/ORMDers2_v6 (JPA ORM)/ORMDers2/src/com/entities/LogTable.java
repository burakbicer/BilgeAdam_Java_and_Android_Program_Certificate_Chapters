package com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.daos.LogTableDAO;
import com.enums.ISLEMTIP;

/**
 * Entity implementation class for Entity: LogTable
 *
 */
@Entity
public class LogTable extends BaseEntity implements Serializable {

	private String sinifAdi;
	
	@Enumerated(EnumType.STRING)
	private ISLEMTIP islemTip;

	private static final long serialVersionUID = 1L;

	public LogTable() {
		super();
	}

	public String getSinifAdi() {
		return this.sinifAdi;
	}

	public LogTable setSinifAdi(String sinifAdi) {
		this.sinifAdi = sinifAdi;
		return this;
	}

	public ISLEMTIP getIslemTip() {
		return islemTip;
	}

	public LogTable setIslemTip(ISLEMTIP islemTip) {
		this.islemTip = islemTip;
		return this;
	}
	
	public void done() {
		new LogTableDAO().create(this);
	}

}
