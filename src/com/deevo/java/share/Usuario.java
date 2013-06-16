package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usur_cod")
	private String usurCod;

	@Column(name="per_pass")
	private String perPass;

	//bi-directional many-to-one association to AlertaParque
	@OneToMany(mappedBy="usuario")
	private List<AlertaParque> alertaParques;

	//bi-directional many-to-one association to Sesion
	@OneToMany(mappedBy="usuario")
	private List<Sesion> sesions;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_dni")
	private Persona persona;

	//bi-directional many-to-many association to Privilegio
	@ManyToMany
	@JoinTable(
		name="USUARIO_PRIVILEGIO"
		, joinColumns={
			@JoinColumn(name="usur_cod")
			}
		, inverseJoinColumns={
			@JoinColumn(name="pri_cod")
			}
		)
	private List<Privilegio> privilegios;

	public Usuario() {
	}

	public String getUsurCod() {
		return this.usurCod;
	}

	public void setUsurCod(String usurCod) {
		this.usurCod = usurCod;
	}

	public String getPerPass() {
		return this.perPass;
	}

	public void setPerPass(String perPass) {
		this.perPass = perPass;
	}

	public List<AlertaParque> getAlertaParques() {
		return this.alertaParques;
	}

	public void setAlertaParques(List<AlertaParque> alertaParques) {
		this.alertaParques = alertaParques;
	}

	public AlertaParque addAlertaParque(AlertaParque alertaParque) {
		getAlertaParques().add(alertaParque);
		alertaParque.setUsuario(this);

		return alertaParque;
	}

	public AlertaParque removeAlertaParque(AlertaParque alertaParque) {
		getAlertaParques().remove(alertaParque);
		alertaParque.setUsuario(null);

		return alertaParque;
	}

	public List<Sesion> getSesions() {
		return this.sesions;
	}

	public void setSesions(List<Sesion> sesions) {
		this.sesions = sesions;
	}

	public Sesion addSesion(Sesion sesion) {
		getSesions().add(sesion);
		sesion.setUsuario(this);

		return sesion;
	}

	public Sesion removeSesion(Sesion sesion) {
		getSesions().remove(sesion);
		sesion.setUsuario(null);

		return sesion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Privilegio> getPrivilegios() {
		return this.privilegios;
	}

	public void setPrivilegios(List<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}

}