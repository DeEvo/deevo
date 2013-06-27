package com.deevo.java.shared;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ale_cod")
	private int aleCod;

	@Column(name="ale_menj")
	private String aleMenj;

	@Column(name="ale_nom")
	private String aleNom;

	@Column(name="ale_tip")
	private String aleTip;

	//bi-directional many-to-one association to AlertaParque
	@OneToMany(mappedBy="alerta")
	private List<AlertaParque> alertaParques;

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

	public List<AlertaParque> getAlertaParques() {
		return this.alertaParques;
	}

	public void setAlertaParques(List<AlertaParque> alertaParques) {
		this.alertaParques = alertaParques;
	}

	public AlertaParque addAlertaParque(AlertaParque alertaParque) {
		getAlertaParques().add(alertaParque);
		alertaParque.setAlerta(this);

		return alertaParque;
	}

	public AlertaParque removeAlertaParque(AlertaParque alertaParque) {
		getAlertaParques().remove(alertaParque);
		alertaParque.setAlerta(null);

		return alertaParque;
	}

	public List<AlertaPrivilegio> getAlertaPrivilegios() {
		return this.alertaPrivilegios;
	}

	public void setAlertaPrivilegios(List<AlertaPrivilegio> alertaPrivilegios) {
		this.alertaPrivilegios = alertaPrivilegios;
	}

	public AlertaPrivilegio addAlertaPrivilegio(AlertaPrivilegio alertaPrivilegio) {
		getAlertaPrivilegios().add(alertaPrivilegio);
		alertaPrivilegio.setAlerta(this);

		return alertaPrivilegio;
	}

	public AlertaPrivilegio removeAlertaPrivilegio(AlertaPrivilegio alertaPrivilegio) {
		getAlertaPrivilegios().remove(alertaPrivilegio);
		alertaPrivilegio.setAlerta(null);

		return alertaPrivilegio;
	}

}