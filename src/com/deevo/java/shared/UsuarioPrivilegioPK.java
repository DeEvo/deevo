package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIO_PRIVILEGIO database table.
 * 
 */
@Embeddable
public class UsuarioPrivilegioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pri_cod")
	private int priCod;

	@Column(name="usur_cod")
	private String usurCod;

	public UsuarioPrivilegioPK() {
	}
	public int getPriCod() {
		return this.priCod;
	}
	public void setPriCod(int priCod) {
		this.priCod = priCod;
	}
	public String getUsurCod() {
		return this.usurCod;
	}
	public void setUsurCod(String usurCod) {
		this.usurCod = usurCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPrivilegioPK)) {
			return false;
		}
		UsuarioPrivilegioPK castOther = (UsuarioPrivilegioPK)other;
		return 
			(this.priCod == castOther.priCod)
			&& this.usurCod.equals(castOther.usurCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.priCod;
		hash = hash * prime + this.usurCod.hashCode();
		
		return hash;
	}
}