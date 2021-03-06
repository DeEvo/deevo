package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GRADO_SECCION database table.
 * 
 */
@Entity
@Table(name="GRADO_SECCION")
public class GradoSeccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GradoSeccionPK id;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="gradoSeccion")
	private List<Aula> aulas;

	//bi-directional many-to-one association to CursoHabilitado
	@OneToMany(mappedBy="gradoSeccion")
	private List<CursoHabilitado> cursoHabilitados;

	public GradoSeccion() {
	}

	public GradoSeccionPK getId() {
		return this.id;
	}

	public void setId(GradoSeccionPK id) {
		this.id = id;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setGradoSeccion(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setGradoSeccion(null);

		return aula;
	}

	public List<CursoHabilitado> getCursoHabilitados() {
		return this.cursoHabilitados;
	}

	public void setCursoHabilitados(List<CursoHabilitado> cursoHabilitados) {
		this.cursoHabilitados = cursoHabilitados;
	}

	public CursoHabilitado addCursoHabilitado(CursoHabilitado cursoHabilitado) {
		getCursoHabilitados().add(cursoHabilitado);
		cursoHabilitado.setGradoSeccion(this);

		return cursoHabilitado;
	}

	public CursoHabilitado removeCursoHabilitado(CursoHabilitado cursoHabilitado) {
		getCursoHabilitados().remove(cursoHabilitado);
		cursoHabilitado.setGradoSeccion(null);

		return cursoHabilitado;
	}

}