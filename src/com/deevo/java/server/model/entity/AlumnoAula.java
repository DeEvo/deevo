package com.deevo.java.server.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ALUMNO_AULA database table.
 * 
 */
@Entity
@Table(name="ALUMNO_AULA")
public class AlumnoAula implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlumnoAulaPK id;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="alu_cod")
	private Alumno alumno1;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="alu_cod")
	private Alumno alumno2;

	//bi-directional many-to-one association to Aula
	@ManyToOne
	@JoinColumn(name="cod_aula")
	private Aula aula;

	public AlumnoAula() {
	}

	public AlumnoAulaPK getId() {
		return this.id;
	}

	public void setId(AlumnoAulaPK id) {
		this.id = id;
	}

	public Alumno getAlumno1() {
		return this.alumno1;
	}

	public void setAlumno1(Alumno alumno1) {
		this.alumno1 = alumno1;
	}

	public Alumno getAlumno2() {
		return this.alumno2;
	}

	public void setAlumno2(Alumno alumno2) {
		this.alumno2 = alumno2;
	}

	public Aula getAula() {
		return this.aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

}