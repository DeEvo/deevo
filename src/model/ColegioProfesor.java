package model;

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

	//bi-directional many-to-one association to Colegio
	@ManyToOne
	@JoinColumn(name="cod_col")
	private Colegio colegio1;

	//bi-directional many-to-one association to Colegio
	@ManyToOne
	@JoinColumn(name="cod_col")
	private Colegio colegio2;

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

	public Colegio getColegio1() {
		return this.colegio1;
	}

	public void setColegio1(Colegio colegio1) {
		this.colegio1 = colegio1;
	}

	public Colegio getColegio2() {
		return this.colegio2;
	}

	public void setColegio2(Colegio colegio2) {
		this.colegio2 = colegio2;
	}

}