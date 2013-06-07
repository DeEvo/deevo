package com.deevo.java.server.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PROFESOR database table.
 * 
 */
@Entity
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pro_cod")
	private int proCod;

	@Column(name="pro_des")
	private String proDes;

	@Temporal(TemporalType.DATE)
	@Column(name="pro_ing")
	private Date proIng;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="profesor")
	private List<Aula> aulas;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_dni")
	private Persona persona;

	public Profesor() {
	}

	public int getProCod() {
		return this.proCod;
	}

	public void setProCod(int proCod) {
		this.proCod = proCod;
	}

	public String getProDes() {
		return this.proDes;
	}

	public void setProDes(String proDes) {
		this.proDes = proDes;
	}

	public Date getProIng() {
		return this.proIng;
	}

	public void setProIng(Date proIng) {
		this.proIng = proIng;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}