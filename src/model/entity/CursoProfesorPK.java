package model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CURSO_PROFESOR database table.
 * 
 */
@Embeddable
public class CursoProfesorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pro_cod")
	private int proCod;

	@Column(name="cod_cur")
	private int codCur;

	public CursoProfesorPK() {
	}
	public int getProCod() {
		return this.proCod;
	}
	public void setProCod(int proCod) {
		this.proCod = proCod;
	}
	public int getCodCur() {
		return this.codCur;
	}
	public void setCodCur(int codCur) {
		this.codCur = codCur;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CursoProfesorPK)) {
			return false;
		}
		CursoProfesorPK castOther = (CursoProfesorPK)other;
		return 
			(this.proCod == castOther.proCod)
			&& (this.codCur == castOther.codCur);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.proCod;
		hash = hash * prime + this.codCur;
		
		return hash;
	}
}