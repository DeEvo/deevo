package com.deevo.java.share;

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

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cur_hab_cod")
	private int curHabCod;

	@Column(name="cod_grado")
	private int codGrado;

	@Column(name="cod_seccion")
	private int codSeccion;

	//bi-directional many-to-one association to CursoProfesor
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cod_cur", referencedColumnName="cod_cur" ),
		@JoinColumn(name="pro_cod", referencedColumnName="pro_cod" )
		})
	private CursoProfesor cursoProfesor;

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

	public int getCodGrado() {
		return this.codGrado;
	}

	public void setCodGrado(int codGrado) {
		this.codGrado = codGrado;
	}

	public int getCodSeccion() {
		return this.codSeccion;
	}

	public void setCodSeccion(int codSeccion) {
		this.codSeccion = codSeccion;
	}

	public CursoProfesor getCursoProfesor() {
		return this.cursoProfesor;
	}

	public void setCursoProfesor(CursoProfesor cursoProfesor) {
		this.cursoProfesor = cursoProfesor;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

}