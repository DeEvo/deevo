package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROFESOR database table.
 * 
 */
@Entity
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_cod")
	private int proCod;

	@Column(name="pro_des")
	private String proDes;

	//bi-directional many-to-one association to ColegioProfesor
	@OneToMany(mappedBy="profesor")
	private List<ColegioProfesor> colegioProfesors;

	//bi-directional many-to-one association to CursoProfesor
	@OneToMany(mappedBy="profesor")
	private List<CursoProfesor> cursoProfesors;

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

	public List<ColegioProfesor> getColegioProfesors() {
		return this.colegioProfesors;
	}

	public void setColegioProfesors(List<ColegioProfesor> colegioProfesors) {
		this.colegioProfesors = colegioProfesors;
	}

	public ColegioProfesor addColegioProfesor(ColegioProfesor colegioProfesor) {
		getColegioProfesors().add(colegioProfesor);
		colegioProfesor.setProfesor(this);

		return colegioProfesor;
	}

	public ColegioProfesor removeColegioProfesor(ColegioProfesor colegioProfesor) {
		getColegioProfesors().remove(colegioProfesor);
		colegioProfesor.setProfesor(null);

		return colegioProfesor;
	}

	public List<CursoProfesor> getCursoProfesors() {
		return this.cursoProfesors;
	}

	public void setCursoProfesors(List<CursoProfesor> cursoProfesors) {
		this.cursoProfesors = cursoProfesors;
	}

	public CursoProfesor addCursoProfesor(CursoProfesor cursoProfesor) {
		getCursoProfesors().add(cursoProfesor);
		cursoProfesor.setProfesor(this);

		return cursoProfesor;
	}

	public CursoProfesor removeCursoProfesor(CursoProfesor cursoProfesor) {
		getCursoProfesors().remove(cursoProfesor);
		cursoProfesor.setProfesor(null);

		return cursoProfesor;
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