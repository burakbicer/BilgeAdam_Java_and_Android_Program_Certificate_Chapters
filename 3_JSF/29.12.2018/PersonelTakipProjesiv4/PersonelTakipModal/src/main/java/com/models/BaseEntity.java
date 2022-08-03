package com.models;

import java.io.Serializable;
import java.lang.Long;
import java.util.Calendar;
import javax.persistence.*;
import static javax.persistence.GenerationType.TABLE;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Entity implementation class for Entity: BaseEntity
 *
 */
@MappedSuperclass 
public class BaseEntity implements Serializable {
 
	   
	@Id
	@GeneratedValue(strategy = TABLE, generator = "SEQ_GEN")
	@TableGenerator(name = "SEQ_GEN", allocationSize = 1, initialValue = 1)
	private Long id;
	
	
	@Temporal(TIMESTAMP)
	private Calendar createdtime = Calendar.getInstance();
	
	@Temporal(TIMESTAMP)
	private Calendar updatedtime;
	
	private static final long serialVersionUID = 1L;

	public BaseEntity() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Calendar getCreatedtime() {
		return this.createdtime;
	}

	public void setCreatedtime(Calendar createdtime) {
		this.createdtime = createdtime;
	}   
	public Calendar getUpdatedtime() {
		return this.updatedtime;
	}

	public void setUpdatedtime(Calendar updatedtime) {
		this.updatedtime = updatedtime;
	}
   
}
