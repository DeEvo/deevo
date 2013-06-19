package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COLEGIO_PRIVILEGIO database table.
 * 
 */
@Embeddable
public class ColegioPrivilegioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pri_cod")
	private int priCod;

	@Column(name="cod_col")
	private int codCol;

	public ColegioPrivilegioPK() {
	}
	public int getPriCod() {
		return this.priCod;
	}
	public void setPriCod(int priCod) {
		this.priCod = priCod;
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
		if (!(other instanceof ColegioPrivilegioPK)) {
			return false;
		}
		ColegioPrivilegioPK castOther = (ColegioPrivilegioPK)other;
		return 
			(this.priCod == castOther.priCod)
			&& (this.codCol == castOther.codCol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.priCod;
		hash = hash * prime + this.codCol;
		
		return hash;
	}
}