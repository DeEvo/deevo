package com.deevo.java.share;

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
	@OneToMany(mappedBy="gradoSeccion1")
	private List<CursoHabilitado> cursoHabilitados1;

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

	public List<CursoHabilitado> getCursoHabilitados1() {
		return this.cursoHabilitados1;
	}

	public void setCursoHabilitados1(List<CursoHabilitado> cursoHabilitados1) {
		this.cursoHabilitados1 = cursoHabilitados1;
	}

}