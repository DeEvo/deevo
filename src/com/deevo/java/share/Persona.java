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
@Table(name="PERSONA")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="per_dni")
	private String perDni;

	@Column(name="per_cel")
	private int perCel;

	@Column(name="per_dir")
	private String perDir;

	@Column(name="per_email")
	private String perEmail;

	@Column(name="per_estc")
	private String perEstc;

	@Temporal(TemporalType.DATE)
	@Column(name="per_ing")
	private Date perIng;

	@Column(name="per_mat")
	private String perMat;

	@Temporal(TemporalType.DATE)
	@Column(name="per_nac")
	private Date perNac;

	@Column(name="per_nom")
	private String perNom;

	@Column(name="per_pat")
	private String perPat;

	@Column(name="per_telf")
	private int perTelf;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="persona")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Familia
	@OneToMany(mappedBy="persona1")
	private List<Familia> familias1;

	//bi-directional many-to-one association to Familia
	@OneToMany(mappedBy="persona2")
	private List<Familia> familias2;

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

	public Date getPerIng() {
		return this.perIng;
	}

	public void setPerIng(Date perIng) {
		this.perIng = perIng;
	}

	public String getPerMat() {
		return this.perMat;
	}

	public void setPerMat(String perMat) {
		this.perMat = perMat;
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

	public String getPerPat() {
		return this.perPat;
	}

	public void setPerPat(String perPat) {
		this.perPat = perPat;
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

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setPersona(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setPersona(null);

		return alumno;
	}

	public List<Familia> getFamilias1() {
		return this.familias1;
	}

	public void setFamilias1(List<Familia> familias1) {
		this.familias1 = familias1;
	}

	public Familia addFamilias1(Familia familias1) {
		getFamilias1().add(familias1);
		familias1.setPersona1(this);

		return familias1;
	}

	public Familia removeFamilias1(Familia familias1) {
		getFamilias1().remove(familias1);
		familias1.setPersona1(null);

		return familias1;
	}

	public List<Familia> getFamilias2() {
		return this.familias2;
	}

	public void setFamilias2(List<Familia> familias2) {
		this.familias2 = familias2;
	}

	public Familia addFamilias2(Familia familias2) {
		getFamilias2().add(familias2);
		familias2.setPersona2(this);

		return familias2;
	}

	public Familia removeFamilias2(Familia familias2) {
		getFamilias2().remove(familias2);
		familias2.setPersona2(null);

		return familias2;
	}

	public List<PadreFamilia> getPadreFamilias() {
		return this.padreFamilias;
	}

	public void setPadreFamilias(List<PadreFamilia> padreFamilias) {
		this.padreFamilias = padreFamilias;
	}

	public PadreFamilia addPadreFamilia(PadreFamilia padreFamilia) {
		getPadreFamilias().add(padreFamilia);
		padreFamilia.setPersona(this);

		return padreFamilia;
	}

	public PadreFamilia removePadreFamilia(PadreFamilia padreFamilia) {
		getPadreFamilias().remove(padreFamilia);
		padreFamilia.setPersona(null);

		return padreFamilia;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setPersona(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setPersona(null);

		return profesor;
	}

	public List<Psicologo> getPsicologos() {
		return this.psicologos;
	}

	public void setPsicologos(List<Psicologo> psicologos) {
		this.psicologos = psicologos;
	}

	public Psicologo addPsicologo(Psicologo psicologo) {
		getPsicologos().add(psicologo);
		psicologo.setPersona(this);

		return psicologo;
	}

	public Psicologo removePsicologo(Psicologo psicologo) {
		getPsicologos().remove(psicologo);
		psicologo.setPersona(null);

		return psicologo;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPersona(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPersona(null);

		return usuario;
	}

}