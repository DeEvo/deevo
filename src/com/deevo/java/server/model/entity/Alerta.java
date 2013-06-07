package com.deevo.java.server.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the ALERTAS database table.
 * 
 */
@Entity
@Table(name="ALERTAS")
public class Alerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ale_cod")
	private int aleCod;

	@Column(name="ale_menj")
	private String aleMenj;

	@Column(name="ale_nom")
	private String aleNom;

	@Column(name="ale_tip")
	private String aleTip;

	//bi-directional one-to-one association to AlertaParque
	@OneToOne(mappedBy="alerta")
	private AlertaParque alertaParque;

	//bi-directional many-to-one association to AlertaPrivilegio
	@OneToMany(mappedBy="alerta")
	private List<AlertaPrivilegio> alertaPrivilegios;

	public Alerta() {
	}

	public int getAleCod() {
		return this.aleCod;
	}

	public void setAleCod(int aleCod) {
		this.aleCod = aleCod;
	}

	public String getAleMenj() {
		return this.aleMenj;
	}

	public void setAleMenj(String aleMenj) {
		this.aleMenj = aleMenj;
	}

	public String getAleNom() {
		return this.aleNom;
	}

	public void setAleNom(String aleNom) {
		this.aleNom = aleNom;
	}

	public String getAleTip() {
		return this.aleTip;
	}

	public void setAleTip(String aleTip) {
		this.aleTip = aleTip;
	}

	public AlertaParque getAlertaParque() {
		return this.alertaParque;
	}

	public void setAlertaParque(AlertaParque alertaParque) {
		this.alertaParque = alertaParque;
	}

	public List<AlertaPrivilegio> getAlertaPrivilegios() {
		return this.alertaPrivilegios;
	}

	public void setAlertaPrivilegios(List<AlertaPrivilegio> alertaPrivilegios) {
		this.alertaPrivilegios = alertaPrivilegios;
	}

}