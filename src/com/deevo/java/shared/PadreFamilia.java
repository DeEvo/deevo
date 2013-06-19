package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PADRE_FAMILIA database table.
 * 
 */
@Entity
@Table(name="PADRE_FAMILIA")
public class PadreFamilia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pad_cod")
	private int padCod;

	@Column(name="pad_bio")
	private byte padBio;

	@Column(name="pad_cant")
	private int padCant;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_dni")
	private Persona persona;

	public PadreFamilia() {
	}

	public int getPadCod() {
		return this.padCod;
	}

	public void setPadCod(int padCod) {
		this.padCod = padCod;
	}

	public byte getPadBio() {
		return this.padBio;
	}

	public void setPadBio(byte padBio) {
		this.padBio = padBio;
	}

	public int getPadCant() {
		return this.padCant;
	}

	public void setPadCant(int padCant) {
		this.padCant = padCant;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}