package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ALERTA_PRIVILEGIOS database table.
 * 
 */
@Entity
@Table(name="ALERTA_PRIVILEGIOS")
public class AlertaPrivilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlertaPrivilegioPK id;

	//bi-directional many-to-one association to Alerta
	@ManyToOne
	@JoinColumn(name="ale_cod",insertable=false, updatable=false)
	private Alerta alerta;

	public AlertaPrivilegio() {
	}

	public AlertaPrivilegioPK getId() {
		return this.id;
	}

	public void setId(AlertaPrivilegioPK id) {
		this.id = id;
	}

	public Alerta getAlerta() {
		return this.alerta;
	}

	public void setAlerta(Alerta alerta) {
		this.alerta = alerta;
	}

}