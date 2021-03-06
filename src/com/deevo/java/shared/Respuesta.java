package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RESPUESTA database table.
 * 
 */
@Entity
@Table(name="RESPUESTA")
public class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RespuestaPK id;

	private String respuesta;

	//bi-directional many-to-one association to Estado
	@OneToMany(mappedBy="respuesta")
	private List<Estado> estados;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="alu_cod", insertable=false, updatable=false)
	private Alumno alumno;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="preg_cod", insertable=false, updatable=false)
	private Pregunta pregunta;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="test_cod", insertable=false, updatable=false)
	private Test test;

	public Respuesta() {
	}

	public RespuestaPK getId() {
		return this.id;
	}

	public void setId(RespuestaPK id) {
		this.id = id;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public List<Estado> getEstados() {
		return this.estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado addEstado(Estado estado) {
		getEstados().add(estado);
		estado.setRespuesta(this);

		return estado;
	}

	public Estado removeEstado(Estado estado) {
		getEstados().remove(estado);
		estado.setRespuesta(null);

		return estado;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}