package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AULA database table.
 * 
 */
@Entity
@Table(name="AULA")
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cod_aula")
	private int codAula;

	//bi-directional many-to-many association to Alumno
	@ManyToMany(mappedBy="aulas")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Colegio
	@ManyToOne
	@JoinColumn(name="cod_col")
	private Colegio colegio;

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
	private PeriodoAcademico periodoAcademico;

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

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Colegio getColegio() {
		return this.colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	public GradoSeccion getGradoSeccion() {
		return this.gradoSeccion;
	}

	public void setGradoSeccion(GradoSeccion gradoSeccion) {
		this.gradoSeccion = gradoSeccion;
	}

	public PeriodoAcademico getPeriodoAcademico() {
		return this.periodoAcademico;
	}

	public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
		this.periodoAcademico = periodoAcademico;
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