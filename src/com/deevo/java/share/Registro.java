package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REGISTRO database table.
 * 
 */
@Entity
public class Registro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reg")
	private int idReg;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="alu_cod")
	private Alumno alumno;

	//bi-directional many-to-one association to Sesion
	@ManyToOne
	@JoinColumn(name="id_ses")
	private Sesion sesion;

	public Registro() {
	}

	public int getIdReg() {
		return this.idReg;
	}

	public void setIdReg(int idReg) {
		this.idReg = idReg;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Sesion getSesion() {
		return this.sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

}