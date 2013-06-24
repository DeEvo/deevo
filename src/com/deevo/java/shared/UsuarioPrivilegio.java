package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIO_PRIVILEGIO database table.
 * 
 */
@Entity
@Table(name="USUARIO_PRIVILEGIO")
public class UsuarioPrivilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioPrivilegioPK id;

	//bi-directional many-to-one association to Colegio
	@ManyToOne
	@JoinColumn(name="cod_col")
	private Colegio colegio;

	//bi-directional many-to-one association to Privilegio
	@ManyToOne
	@JoinColumn(name="pri_cod")
	private Privilegio privilegio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usur_cod")
	private Usuario usuario;

	public UsuarioPrivilegio() {
	}

	public UsuarioPrivilegioPK getId() {
		return this.id;
	}

	public void setId(UsuarioPrivilegioPK id) {
		this.id = id;
	}

	public Colegio getColegio() {
		return this.colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	public Privilegio getPrivilegio() {
		return this.privilegio;
	}

	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}