package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ALERTA_PARQUE database table.
 * 
 */
@Entity
@Table(name="ALERTA_PARQUE")
public class AlertaParque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aler")
	private int idAler;

	//bi-directional many-to-one association to Alerta
	@ManyToOne
	@JoinColumn(name="ale_cod")
	private Alerta alerta;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="alu_cod", referencedColumnName="alu_cod"),
		@JoinColumn(name="num_estado", referencedColumnName="num_estado")
		})
	private Estado estado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usur_cod")
	private Usuario usuario;

	public AlertaParque() {
	}

	public int getIdAler() {
		return this.idAler;
	}

	public void setIdAler(int idAler) {
		this.idAler = idAler;
	}

	public Alerta getAlerta() {
		return this.alerta;
	}

	public void setAlerta(Alerta alerta) {
		this.alerta = alerta;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}