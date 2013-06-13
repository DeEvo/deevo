package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COLEGIO_PRIVILEGIO database table.
 * 
 */
@Entity
@Table(name="COLEGIO_PRIVILEGIO")
public class ColegioPrivilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ColegioPrivilegioPK id;

	//bi-directional many-to-one association to Colegio
	@ManyToOne
	@JoinColumn(name="cod_col")
	private Colegio colegio;

	public ColegioPrivilegio() {
	}

	public ColegioPrivilegioPK getId() {
		return this.id;
	}

	public void setId(ColegioPrivilegioPK id) {
		this.id = id;
	}

	public Colegio getColegio() {
		return this.colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

}