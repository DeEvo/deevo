package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CURSO_PROFESOR database table.
 * 
 */
@Entity
@Table(name="CURSO_PROFESOR")
public class CursoProfesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoProfesorPK id;

	private byte estado;

	//bi-directional many-to-one association to CursoHabilitado
	@OneToMany(mappedBy="cursoProfesor")
	private List<CursoHabilitado> cursoHabilitados;

	//bi-directional many-to-many association to Aula
	@ManyToMany
	@JoinTable(
		name="CURSO_PROFESOR_AULA"
		, joinColumns={
			@JoinColumn(name="cod_cur", referencedColumnName="cod_cur"),
			@JoinColumn(name="pro_cod", referencedColumnName="pro_cod")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cod_aula")
			}
		)
	private List<Aula> aulas;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="cod_cur")
	private Curso curso;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="pro_cod")
	private Profesor profesor;

	public CursoProfesor() {
	}

	public CursoProfesorPK getId() {
		return this.id;
	}

	public void setId(CursoProfesorPK id) {
		this.id = id;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public List<CursoHabilitado> getCursoHabilitados() {
		return this.cursoHabilitados;
	}

	public void setCursoHabilitados(List<CursoHabilitado> cursoHabilitados) {
		this.cursoHabilitados = cursoHabilitados;
	}

	public CursoHabilitado addCursoHabilitado(CursoHabilitado cursoHabilitado) {
		getCursoHabilitados().add(cursoHabilitado);
		cursoHabilitado.setCursoProfesor(this);

		return cursoHabilitado;
	}

	public CursoHabilitado removeCursoHabilitado(CursoHabilitado cursoHabilitado) {
		getCursoHabilitados().remove(cursoHabilitado);
		cursoHabilitado.setCursoProfesor(null);

		return cursoHabilitado;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}