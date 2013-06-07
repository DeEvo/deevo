package com.deevo.java.server.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * The persistent class for the COLEGIO database table.
 * 
 */
@Entity
public class Colegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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
	private int colUgel;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="colegio1")
	private List<Aula> aulas1;

	//bi-directional many-to-one association to ColegioProfesor
	@OneToMany(mappedBy="colegio1")
	private List<ColegioProfesor> colegioProfesors1;

	//bi-directional many-to-one association to Sesion
	@OneToMany(mappedBy="colegio")
	private List<Sesion> sesions;

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

	public int getColUgel() {
		return this.colUgel;
	}

	public void setColUgel(int colUgel) {
		this.colUgel = colUgel;
	}

	public List<Aula> getAulas1() {
		return this.aulas1;
	}

	public void setAulas1(List<Aula> aulas1) {
		this.aulas1 = aulas1;
	}

	public List<ColegioProfesor> getColegioProfesors1() {
		return this.colegioProfesors1;
	}

	public void setColegioProfesors1(List<ColegioProfesor> colegioProfesors1) {
		this.colegioProfesors1 = colegioProfesors1;
	}

	public List<Sesion> getSesions() {
		return this.sesions;
	}

	public void setSesions(List<Sesion> sesions) {
		this.sesions = sesions;
	}

}