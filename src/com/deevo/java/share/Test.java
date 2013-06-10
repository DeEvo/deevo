package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEST database table.
 * 
 */
@Entity
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="test_cod")
	private int testCod;

	@Column(name="test_des")
	private String testDes;

	@Column(name="test_ela")
	private String testEla;

	//bi-directional many-to-one association to Pregunta
	@OneToMany(mappedBy="test")
	private List<Pregunta> preguntas;

	//bi-directional many-to-one association to Respuesta
	@OneToMany(mappedBy="test")
	private List<Respuesta> respuestas;

	//bi-directional many-to-one association to MetodoCalificacion
	@ManyToOne
	@JoinColumn(name="met_cod")
	private MetodoCalificacion metodoCalificacion;

	//bi-directional many-to-one association to TestTipo
	@ManyToOne
	@JoinColumn(name="test_tipo_cod")
	private TestTipo testTipo;

	//bi-directional many-to-many association to CursoHabilitado
	@ManyToMany
	@JoinTable(
		name="TEST_CURSO"
		, joinColumns={
			@JoinColumn(name="test_cod")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cur_hab_cod")
			}
		)
	private List<CursoHabilitado> cursoHabilitados;

	//bi-directional many-to-one association to TestPrivilegio
	@OneToMany(mappedBy="test1")
	private List<TestPrivilegio> testPrivilegios1;

	public Test() {
	}

	public int getTestCod() {
		return this.testCod;
	}

	public void setTestCod(int testCod) {
		this.testCod = testCod;
	}

	public String getTestDes() {
		return this.testDes;
	}

	public void setTestDes(String testDes) {
		this.testDes = testDes;
	}

	public String getTestEla() {
		return this.testEla;
	}

	public void setTestEla(String testEla) {
		this.testEla = testEla;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public MetodoCalificacion getMetodoCalificacion() {
		return this.metodoCalificacion;
	}

	public void setMetodoCalificacion(MetodoCalificacion metodoCalificacion) {
		this.metodoCalificacion = metodoCalificacion;
	}

	public TestTipo getTestTipo() {
		return this.testTipo;
	}

	public void setTestTipo(TestTipo testTipo) {
		this.testTipo = testTipo;
	}

	public List<CursoHabilitado> getCursoHabilitados() {
		return this.cursoHabilitados;
	}

	public void setCursoHabilitados(List<CursoHabilitado> cursoHabilitados) {
		this.cursoHabilitados = cursoHabilitados;
	}

	public List<TestPrivilegio> getTestPrivilegios1() {
		return this.testPrivilegios1;
	}

	public void setTestPrivilegios1(List<TestPrivilegio> testPrivilegios1) {
		this.testPrivilegios1 = testPrivilegios1;
	}

}
