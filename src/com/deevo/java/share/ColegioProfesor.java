package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COLEGIO_PROFESOR database table.
 * 
 */
@Entity
@Table(name="COLEGIO_PROFESOR")
public class ColegioProfesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ColegioProfesorPK id;

	private byte estado;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="pro_cod" , insertable=false, updatable=false)
	private Profesor profesor;

	//bi-directional many-to-one association to Colegio
	@ManyToOne
	@JoinColumn(name="cod_col", insertable=false, updatable=false)
	private Colegio colegio;

	public ColegioProfesor() {
	}

	public ColegioProfesorPK getId() {
		return this.id;
	}

	public void setId(ColegioProfesorPK id) {
		this.id = id;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Colegio getColegio() {
		return this.colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

}