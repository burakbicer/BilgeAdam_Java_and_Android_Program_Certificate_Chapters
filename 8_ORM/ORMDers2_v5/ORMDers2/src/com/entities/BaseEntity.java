package com.entities;

import static javax.persistence.GenerationType.TABLE;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: BaseEntity
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(generator="PK_ANA_TABLOSU")
	@TableGenerator(
	allocationSize=1,
	initialValue=1, 
	table="PK_ANA_TABLOSU", 
	name = "PK_ANA_TABLOSU",
	pkColumnName="PK_NAME",
	pkColumnValue="PK_VAL"
			)	
	private Long id;

	private Boolean silindi=false;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdDate = Calendar.getInstance();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar deletedDate;
	
	private static final long serialVersionUID = 1L;

	public BaseEntity() {
		super();
	}

	public Boolean getSilindi() {
		return this.silindi;
	}

	public void setSilindi(Boolean silindi) {
		this.silindi = silindi;
	}

	public Calendar getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getDeletedDate() {
		return this.deletedDate;
	}

	public void setDeletedDate(Calendar deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((deletedDate == null) ? 0 : deletedDate.hashCode());
		result = prime * result + ((silindi == null) ? 0 : silindi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (deletedDate == null) {
			if (other.deletedDate != null)
				return false;
		} else if (!deletedDate.equals(other.deletedDate))
			return false;
		if (silindi == null) {
			if (other.silindi != null)
				return false;
		} else if (!silindi.equals(other.silindi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseEntity [silindi=" + silindi + ", createdDate=" + createdDate + ", deletedDate=" + deletedDate + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
