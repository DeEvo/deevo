package com.deevo.java.server.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AULA database table.
 * 
 */
@Entity
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_aula")
	private int codAula;

	//bi-directional many-to-one association to AlumnoAula
	@OneToMany(mappedBy="aula")
	private List<AlumnoAula> alumnoAulas;

	//bi-directional many-to-one association to Colegio
	@ManyToOne
	@JoinColumn(name="cod_col")
	private Colegio colegio1;

	//bi-directional many-to-one association to Colegio
	@ManyToOne
	@JoinColumn(name="cod_col")
	private Colegio colegio2;

	//bi-directional many-to-one association to GradoSeccion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cod_grado", referencedColumnName="cod_grado"),
		@JoinColumn(name="cod_seccion", referencedColumnName="cod_seccion")
		})
	private GradoSeccion gradoSeccion;

	//bi-directional many-to-one association to PeriodoAcademico
	@ManyToOne
	@JoinColumn(name="cod_per")
	private PeriodoAcademico periodoAcademico1;

	//bi-directional many-to-one association to PeriodoAcademico
	@ManyToOne
	@JoinColumn(name="cod_per")
	private PeriodoAcademico periodoAcademico2;

	//bi-directional many-to-one association to PeriodoAcademico
	@ManyToOne
	@JoinColumn(name="cod_per")
	private PeriodoAcademico periodoAcademico3;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="pro_cod")
	private Profesor profesor;

	//bi-directional many-to-one association to Psicologo
	@ManyToOne
	@JoinColumn(name="psi_cod")
	private Psicologo psicologo;

	//bi-directional many-to-many association to CursoProfesor
	@ManyToMany(mappedBy="aulas")
	private List<CursoProfesor> cursoProfesors;

	public Aula() {
	}

	public int getCodAula() {
		return this.codAula;
	}

	public void setCodAula(int codAula) {
		this.codAula = codAula;
	}

	public List<AlumnoAula> getAlumnoAulas() {
		return this.alumnoAulas;
	}

	public void setAlumnoAulas(List<AlumnoAula> alumnoAulas) {
		this.alumnoAulas = alumnoAulas;
	}

	public Colegio getColegio1() {
		return this.colegio1;
	}

	public void setColegio1(Colegio colegio1) {
		this.colegio1 = colegio1;
	}

	public Colegio getColegio2() {
		return this.colegio2;
	}

	public void setColegio2(Colegio colegio2) {
		this.colegio2 = colegio2;
	}

	public GradoSeccion getGradoSeccion() {
		return this.gradoSeccion;
	}

	public void setGradoSeccion(GradoSeccion gradoSeccion) {
		this.gradoSeccion = gradoSeccion;
	}

	public PeriodoAcademico getPeriodoAcademico1() {
		return this.periodoAcademico1;
	}

	public void setPeriodoAcademico1(PeriodoAcademico periodoAcademico1) {
		this.periodoAcademico1 = periodoAcademico1;
	}

	public PeriodoAcademico getPeriodoAcademico2() {
		return this.periodoAcademico2;
	}

	public void setPeriodoAcademico2(PeriodoAcademico periodoAcademico2) {
		this.periodoAcademico2 = periodoAcademico2;
	}

	public PeriodoAcademico getPeriodoAcademico3() {
		return this.periodoAcademico3;
	}

	public void setPeriodoAcademico3(PeriodoAcademico periodoAcademico3) {
		this.periodoAcademico3 = periodoAcademico3;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Psicologo getPsicologo() {
		return this.psicologo;
	}

	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}

	public List<CursoProfesor> getCursoProfesors() {
		return this.cursoProfesors;
	}

	public void setCursoProfesors(List<CursoProfesor> cursoProfesors) {
		this.cursoProfesors = cursoProfesors;
	}

}