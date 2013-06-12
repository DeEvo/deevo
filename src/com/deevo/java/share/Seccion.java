package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SECCION database table.
 * 
 */
@Entity
@Table(name="SECCION")
public class Seccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_seccion")
	private int codSeccion;

	@Column(name="desc_sec")
	private String descSec;

	//bi-directional many-to-many association to Grado
	@ManyToMany(mappedBy="seccions")
	private List<Grado> grados;

	public Seccion() {
	}

	public int getCodSeccion() {
		return this.codSeccion;
	}

	public void setCodSeccion(int codSeccion) {
		this.codSeccion = codSeccion;
	}

	public String getDescSec() {
		return this.descSec;
	}

	public void setDescSec(String descSec) {
		this.descSec = descSec;
	}

	public List<Grado> getGrados() {
		return this.grados;
	}

	public void setGrados(List<Grado> grados) {
		this.grados = grados;
	}

}