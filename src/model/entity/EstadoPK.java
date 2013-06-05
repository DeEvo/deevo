package model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ESTADOS database table.
 * 
 */
@Embeddable
public class EstadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="num_estado")
	private int numEstado;

	@Column(name="alu_cod")
	private int aluCod;

	public EstadoPK() {
	}
	public int getNumEstado() {
		return this.numEstado;
	}
	public void setNumEstado(int numEstado) {
		this.numEstado = numEstado;
	}
	public int getAluCod() {
		return this.aluCod;
	}
	public void setAluCod(int aluCod) {
		this.aluCod = aluCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EstadoPK)) {
			return false;
		}
		EstadoPK castOther = (EstadoPK)other;
		return 
			(this.numEstado == castOther.numEstado)
			&& (this.aluCod == castOther.aluCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numEstado;
		hash = hash * prime + this.aluCod;
		
		return hash;
	}
}