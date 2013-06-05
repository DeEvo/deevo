package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PADRE_FAMILIA database table.
 * 
 */
@Entity
@Table(name="PADRE_FAMILIA")
public class PadreFamilia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pad_cod")
	private int padCod;

	@Column(name="pad_cant")
	private int padCant;

	@Column(name="pad_fam")
	private int padFam;

	@Column(name="pad_pin")
	private int padPin;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="padreFamilia")
	private List<Alumno> alumnos;

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

	public int getPadCant() {
		return this.padCant;
	}

	public void setPadCant(int padCant) {
		this.padCant = padCant;
	}

	public int getPadFam() {
		return this.padFam;
	}

	public void setPadFam(int padFam) {
		this.padFam = padFam;
	}

	public int getPadPin() {
		return this.padPin;
	}

	public void setPadPin(int padPin) {
		this.padPin = padPin;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}