package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private String colUgel;

	//bi-directional many-to-many association to Psicologo
	@ManyToMany(mappedBy="colegios")
	private List<Psicologo> psicologos;

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

	public List<Psicologo> getPsicologos() {
		return this.psicologos;
	}

	public void setPsicologos(List<Psicologo> psicologos) {
		this.psicologos = psicologos;
	}

}