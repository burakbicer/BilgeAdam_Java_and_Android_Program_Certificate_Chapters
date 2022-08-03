package com.selcukuzunsoy.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.TABLE;
import javax.persistence.TableGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = TABLE, generator = "SEQ_GEN")
	@TableGenerator(name = "SEQ_GEN", allocationSize = 1, initialValue = 1)
	private Long id;

	@Column(length = 50)
	private String ad;

	@Column(length = 100)
	private String soyad;

	@Column(length = 11, nullable = false, unique = true)
	private String tc;

}
