package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PERSONA database table.
 * 
 */
@Entity
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="per_dni")
	private String perDni;

	@Column(name="per_can")
	private int perCan;

	@Column(name="per_cel")
	private int perCel;

	@Column(name="per_dir")
	private String perDir;

	@Column(name="per_email")
	private String perEmail;

	@Column(name="per_estc")
	private String perEstc;

	@Temporal(TemporalType.DATE)
	@Column(name="per_nac")
	private Date perNac;

	@Column(name="per_nom")
	private String perNom;
	
	@Column(name="per_appatern")
	private String perAppatern;
	
	@Column(name="per_appmatern")
	private String perAppmatern;

	@Column(name="per_telf")
	private int perTelf;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="persona")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to PadreFamilia
	@OneToMany(mappedBy="persona")
	private List<PadreFamilia> padreFamilias;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="persona")
	private List<Profesor> profesors;

	//bi-directional many-to-one association to Psicologo
	@OneToMany(mappedBy="persona")
	private List<Psicologo> psicologos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="persona")
	private List<Usuario> usuarios;

	public Persona() {
	}

	public String getPerDni() {
		return this.perDni;
	}

	public void setPerDni(String perDni) {
		this.perDni = perDni;
	}

	public int getPerCan() {
		return this.perCan;
	}

	public void setPerCan(int perCan) {
		this.perCan = perCan;
	}

	public int getPerCel() {
		return this.perCel;
	}

	public void setPerCel(int perCel) {
		this.perCel = perCel;
	}

	public String getPerDir() {
		return this.perDir;
	}

	public void setPerDir(String perDir) {
		this.perDir = perDir;
	}

	public String getPerEmail() {
		return this.perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public String getPerEstc() {
		return this.perEstc;
	}

	public void setPerEstc(String perEstc) {
		this.perEstc = perEstc;
	}

	public Date getPerNac() {
		return this.perNac;
	}

	public void setPerNac(Date perNac) {
		this.perNac = perNac;
	}

	public String getPerNom() {
		return this.perNom;
	}

	public void setPerNom(String perNom) {
		this.perNom = perNom;
	}

	public int getPerTelf() {
		return this.perTelf;
	}

	public void setPerTelf(int perTelf) {
		this.perTelf = perTelf;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public List<PadreFamilia> getPadreFamilias() {
		return this.padreFamilias;
	}

	public void setPadreFamilias(List<PadreFamilia> padreFamilias) {
		this.padreFamilias = padreFamilias;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public List<Psicologo> getPsicologos() {
		return this.psicologos;
	}

	public void setPsicologos(List<Psicologo> psicologos) {
		this.psicologos = psicologos;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}