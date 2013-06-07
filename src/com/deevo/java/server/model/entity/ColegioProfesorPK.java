package com.deevo.java.server.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COLEGIO_PROFESOR database table.
 * 
 */
@Embeddable
public class ColegioProfesorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pro_cod")
	private int proCod;

	@Column(name="cod_col")
	private int codCol;

	public ColegioProfesorPK() {
	}
	public int getProCod() {
		return this.proCod;
	}
	public void setProCod(int proCod) {
		this.proCod = proCod;
	}
	public int getCodCol() {
		return this.codCol;
	}
	public void setCodCol(int codCol) {
		this.codCol = codCol;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ColegioProfesorPK)) {
			return false;
		}
		ColegioProfesorPK castOther = (ColegioProfesorPK)other;
		return 
			(this.proCod == castOther.proCod)
			&& (this.codCol == castOther.codCol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.proCod;
		hash = hash * prime + this.codCol;
		
		return hash;
	}
}