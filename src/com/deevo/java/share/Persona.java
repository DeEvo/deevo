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

	private String sexo;

	//bi-directional many-to-one association to Psicologo
	@OneToMany(mappedBy="persona")
	private List<Psicologo> psicologos;

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

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

}