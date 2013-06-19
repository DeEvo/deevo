package com.deevo.java.shared;

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

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="test_cod")
	private int testCod;

	@Column(name="test_des")
	private String testDes;

	@Column(name="test_nom")
	private String testNom;

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

	//bi-directional many-to-many association to Privilegio
	@ManyToMany
	@JoinTable(
		name="TEST_PRIVILEGIO"
		, joinColumns={
			@JoinColumn(name="test_cod")
			}
		, inverseJoinColumns={
			@JoinColumn(name="pri_cod")
			}
		)
	private List<Privilegio> privilegios;

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

	public String getTestNom() {
		return this.testNom;
	}

	public void setTestNom(String testNom) {
		this.testNom = testNom;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Pregunta addPregunta(Pregunta pregunta) {
		getPreguntas().add(pregunta);
		pregunta.setTest(this);

		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setTest(null);

		return pregunta;
	}

	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Respuesta addRespuesta(Respuesta respuesta) {
		getRespuestas().add(respuesta);
		respuesta.setTest(this);

		return respuesta;
	}

	public Respuesta removeRespuesta(Respuesta respuesta) {
		getRespuestas().remove(respuesta);
		respuesta.setTest(null);

		return respuesta;
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

	public List<Privilegio> getPrivilegios() {
		return this.privilegios;
	}

	public void setPrivilegios(List<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}

}