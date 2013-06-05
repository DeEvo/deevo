package model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GRADO_SECCION database table.
 * 
 */
@Embeddable
public class GradoSeccionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_seccion")
	private int codSeccion;

	@Column(name="cod_grado")
	private int codGrado;

	public GradoSeccionPK() {
	}
	public int getCodSeccion() {
		return this.codSeccion;
	}
	public void setCodSeccion(int codSeccion) {
		this.codSeccion = codSeccion;
	}
	public int getCodGrado() {
		return this.codGrado;
	}
	public void setCodGrado(int codGrado) {
		this.codGrado = codGrado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GradoSeccionPK)) {
			return false;
		}
		GradoSeccionPK castOther = (GradoSeccionPK)other;
		return 
			(this.codSeccion == castOther.codSeccion)
			&& (this.codGrado == castOther.codGrado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codSeccion;
		hash = hash * prime + this.codGrado;
		
		return hash;
	}
}