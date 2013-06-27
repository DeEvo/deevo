package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COLEGIO database table.
 * 
 */
@Entity
@Table(name="COLEGIO")
public class Colegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_col")
	private int codCol;

	@Column(name="col_dir")
	private String colDir;

	@Column(name="col_distri")
	private String colDistri;

	@Column(name="col_nom")
	private String colNom;

	@Column(name="col_sector")
	private String colSector;

	@Column(name="col_telf")
	private int colTelf;

	@Column(name="col_ugel")
	private String colUgel;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="colegio")
	private List<Aula> aulas;

	//bi-directional many-to-one association to ColegioProfesor
	@OneToMany(mappedBy="colegio")
	private List<ColegioProfesor> colegioProfesors;

	//bi-directional many-to-many association to Psicologo
	@ManyToMany(mappedBy="colegios")
	private List<Psicologo> psicologos;

	//bi-directional many-to-one association to Sesion
	@OneToMany(mappedBy="colegio")
	private List<Sesion> sesions;

	//bi-directional many-to-one association to UsuarioPrivilegio
	@OneToMany(mappedBy="colegio")
	private List<UsuarioPrivilegio> usuarioPrivilegios;

	public Colegio() {
	}

	public int getCodCol() {
		return this.codCol;
	}

	public void setCodCol(int codCol) {
		this.codCol = codCol;
	}

	public String getColDir() {
		return this.colDir;
	}

	public void setColDir(String colDir) {
		this.colDir = colDir;
	}

	public String getColDistri() {
		return this.colDistri;
	}

	public void setColDistri(String colDistri) {
		this.colDistri = colDistri;
	}

	public String getColNom() {
		return this.colNom;
	}

	public void setColNom(String colNom) {
		this.colNom = colNom;
	}

	public String getColSector() {
		return this.colSector;
	}

	public void setColSector(String colSector) {
		this.colSector = colSector;
	}

	public int getColTelf() {
		return this.colTelf;
	}

	public void setColTelf(int colTelf) {
		this.colTelf = colTelf;
	}

	public String getColUgel() {
		return this.colUgel;
	}

	public void setColUgel(String colUgel) {
		this.colUgel = colUgel;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setColegio(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setColegio(null);

		return aula;
	}

	public List<ColegioProfesor> getColegioProfesors() {
		return this.colegioProfesors;
	}

	public void setColegioProfesors(List<ColegioProfesor> colegioProfesors) {
		this.colegioProfesors = colegioProfesors;
	}

	public ColegioProfesor addColegioProfesor(ColegioProfesor colegioProfesor) {
		getColegioProfesors().add(colegioProfesor);
		colegioProfesor.setColegio(this);

		return colegioProfesor;
	}

	public ColegioProfesor removeColegioProfesor(ColegioProfesor colegioProfesor) {
		getColegioProfesors().remove(colegioProfesor);
		colegioProfesor.setColegio(null);

		return colegioProfesor;
	}

	public List<Psicologo> getPsicologos() {
		return this.psicologos;
	}

	public void setPsicologos(List<Psicologo> psicologos) {
		this.psicologos = psicologos;
	}

	public List<Sesion> getSesions() {
		return this.sesions;
	}

	public void setSesions(List<Sesion> sesions) {
		this.sesions = sesions;
	}

	public Sesion addSesion(Sesion sesion) {
		getSesions().add(sesion);
		sesion.setColegio(this);

		return sesion;
	}

	public Sesion removeSesion(Sesion sesion) {
		getSesions().remove(sesion);
		sesion.setColegio(null);

		return sesion;
	}

	public List<UsuarioPrivilegio> getUsuarioPrivilegios() {
		return this.usuarioPrivilegios;
	}

	public void setUsuarioPrivilegios(List<UsuarioPrivilegio> usuarioPrivilegios) {
		this.usuarioPrivilegios = usuarioPrivilegios;
	}

	public UsuarioPrivilegio addUsuarioPrivilegio(UsuarioPrivilegio usuarioPrivilegio) {
		getUsuarioPrivilegios().add(usuarioPrivilegio);
		usuarioPrivilegio.setColegio(this);

		return usuarioPrivilegio;
	}

	public UsuarioPrivilegio removeUsuarioPrivilegio(UsuarioPrivilegio usuarioPrivilegio) {
		getUsuarioPrivilegios().remove(usuarioPrivilegio);
		usuarioPrivilegio.setColegio(null);

		return usuarioPrivilegio;
	}

}