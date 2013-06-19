package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FAMILIA database table.
 * 
 */
@Embeddable
public class FamiliaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="per_a")
	private String perA;

	@Column(name="per_b")
	private String perB;

	public FamiliaPK() {
	}
	public String getPerA() {
		return this.perA;
	}
	public void setPerA(String perA) {
		this.perA = perA;
	}
	public String getPerB() {
		return this.perB;
	}
	public void setPerB(String perB) {
		this.perB = perB;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FamiliaPK)) {
			return false;
		}
		FamiliaPK castOther = (FamiliaPK)other;
		return 
			this.perA.equals(castOther.perA)
			&& this.perB.equals(castOther.perB);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.perA.hashCode();
		hash = hash * prime + this.perB.hashCode();
		
		return hash;
	}
}