package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ALUMNO_AULA database table.
 * 
 */
@Embeddable
public class AlumnoAulaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="alu_cod")
	private int aluCod;

	@Column(name="cod_aula")
	private int codAula;

	public AlumnoAulaPK() {
	}
	public int getAluCod() {
		return this.aluCod;
	}
	public void setAluCod(int aluCod) {
		this.aluCod = aluCod;
	}
	public int getCodAula() {
		return this.codAula;
	}
	public void setCodAula(int codAula) {
		this.codAula = codAula;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AlumnoAulaPK)) {
			return false;
		}
		AlumnoAulaPK castOther = (AlumnoAulaPK)other;
		return 
			(this.aluCod == castOther.aluCod)
			&& (this.codAula == castOther.codAula);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.aluCod;
		hash = hash * prime + this.codAula;
		
		return hash;
	}
}