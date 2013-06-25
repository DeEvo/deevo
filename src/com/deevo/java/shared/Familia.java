package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FAMILIA database table.
 * 
 */
@Entity
@Table(name="FAMILIA")
public class Familia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FamiliaPK id;

	@Column(name="fam_des")
	private String famDes;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_a")
	private Persona persona1;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_b")
	private Persona persona2;

	public Familia() {
	}

	public FamiliaPK getId() {
		return this.id;
	}

	public void setId(FamiliaPK id) {
		this.id = id;
	}

	public String getFamDes() {
		return this.famDes;
	}

	public void setFamDes(String famDes) {
		this.famDes = famDes;
	}

	public Persona getPersona1() {
		return this.persona1;
	}

	public void setPersona1(Persona persona1) {
		this.persona1 = persona1;
	}

	public Persona getPersona2() {
		return this.persona2;
	}

	public void setPersona2(Persona persona2) {
		this.persona2 = persona2;
	}

}