package com.deevo.java.server.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CURSO_HABILITADO database table.
 * 
 */
@Entity
@Table(name="CURSO_HABILITADO")
public class CursoHabilitado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cur_hab_cod")
	private int curHabCod;

	//bi-directional many-to-one association to CursoProfesor
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cod_cur", referencedColumnName="cod_cur"),
		@JoinColumn(name="pro_cod", referencedColumnName="pro_cod")
		})
	private CursoProfesor cursoProfesor;

	//bi-directional many-to-one association to GradoSeccion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cod_grado", referencedColumnName="cod_grado"),
		@JoinColumn(name="cod_seccion", referencedColumnName="cod_seccion")
		})
	private GradoSeccion gradoSeccion1;

	//bi-directional many-to-one association to GradoSeccion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cod_grado", referencedColumnName="cod_grado"),
		@JoinColumn(name="cod_seccion", referencedColumnName="cod_seccion")
		})
	private GradoSeccion gradoSeccion2;

	//bi-directional many-to-many association to Test
	@ManyToMany(mappedBy="cursoHabilitados")
	private List<Test> tests;

	public CursoHabilitado() {
	}

	public int getCurHabCod() {
		return this.curHabCod;
	}

	public void setCurHabCod(int curHabCod) {
		this.curHabCod = curHabCod;
	}

	public CursoProfesor getCursoProfesor() {
		return this.cursoProfesor;
	}

	public void setCursoProfesor(CursoProfesor cursoProfesor) {
		this.cursoProfesor = cursoProfesor;
	}

	public GradoSeccion getGradoSeccion1() {
		return this.gradoSeccion1;
	}

	public void setGradoSeccion1(GradoSeccion gradoSeccion1) {
		this.gradoSeccion1 = gradoSeccion1;
	}

	public GradoSeccion getGradoSeccion2() {
		return this.gradoSeccion2;
	}

	public void setGradoSeccion2(GradoSeccion gradoSeccion2) {
		this.gradoSeccion2 = gradoSeccion2;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

}