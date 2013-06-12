package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROFESOR database table.
 * 
 */
@Entity
@Table(name="PROFESOR")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pro_cod")
	private int proCod;

	@Column(name="pro_des")
	private String proDes;

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

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setProfesor(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setProfesor(null);

		return aula;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}