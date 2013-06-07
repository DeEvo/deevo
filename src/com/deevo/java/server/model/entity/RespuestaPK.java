package com.deevo.java.server.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESPUESTA database table.
 * 
 */
@Embeddable
public class RespuestaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="alu_cod")
	private int aluCod;

	@Column(name="preg_cod")
	private int pregCod;

	@Column(name="test_cod")
	private int testCod;

	public RespuestaPK() {
	}
	public int getAluCod() {
		return this.aluCod;
	}
	public void setAluCod(int aluCod) {
		this.aluCod = aluCod;
	}
	public int getPregCod() {
		return this.pregCod;
	}
	public void setPregCod(int pregCod) {
		this.pregCod = pregCod;
	}
	public int getTestCod() {
		return this.testCod;
	}
	public void setTestCod(int testCod) {
		this.testCod = testCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RespuestaPK)) {
			return false;
		}
		RespuestaPK castOther = (RespuestaPK)other;
		return 
			(this.aluCod == castOther.aluCod)
			&& (this.pregCod == castOther.pregCod)
			&& (this.testCod == castOther.testCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.aluCod;
		hash = hash * prime + this.pregCod;
		hash = hash * prime + this.testCod;
		
		return hash;
	}
}