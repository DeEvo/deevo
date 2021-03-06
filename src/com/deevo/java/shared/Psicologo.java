package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PSICOLOGO database table.
 * 
 */
@Entity
@Table(name="PSICOLOGO")
public class Psicologo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="psi_cod")
	private int psiCod;

	@Column(name="psi_des")
	private String psiDes;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="psicologo")
	private List<Aula> aulas;

	//bi-directional many-to-many association to Colegio
	@ManyToMany
	@JoinTable(
		name="PSICOLOGO_COLEGIO"
		, joinColumns={
			@JoinColumn(name="psi_cod")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cod_col")
			}
		)
	private List<Colegio> colegios;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_dni")
	private Persona persona;

	public Psicologo() {
	}

	public int getPsiCod() {
		return this.psiCod;
	}

	public void setPsiCod(int psiCod) {
		this.psiCod = psiCod;
	}

	public String getPsiDes() {
		return this.psiDes;
	}

	public void setPsiDes(String psiDes) {
		this.psiDes = psiDes;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setPsicologo(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setPsicologo(null);

		return aula;
	}

	public List<Colegio> getColegios() {
		return this.colegios;
	}

	public void setColegios(List<Colegio> colegios) {
		this.colegios = colegios;
	}
	
	public Colegio addColegio(Colegio colegio) {
		this.colegios.add(colegio);
		return colegio;
	}

	
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}