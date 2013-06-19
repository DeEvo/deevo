package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ALERTA_PRIVILEGIOS database table.
 * 
 */
@Embeddable
public class AlertaPrivilegioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ale_cod")
	private int aleCod;

	@Column(name="pri_cod")
	private int priCod;

	public AlertaPrivilegioPK() {
	}
	public int getAleCod() {
		return this.aleCod;
	}
	public void setAleCod(int aleCod) {
		this.aleCod = aleCod;
	}
	public int getPriCod() {
		return this.priCod;
	}
	public void setPriCod(int priCod) {
		this.priCod = priCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AlertaPrivilegioPK)) {
			return false;
		}
		AlertaPrivilegioPK castOther = (AlertaPrivilegioPK)other;
		return 
			(this.aleCod == castOther.aleCod)
			&& (this.priCod == castOther.priCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.aleCod;
		hash = hash * prime + this.priCod;
		
		return hash;
	}
}