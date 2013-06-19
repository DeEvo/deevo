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

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ale_cod")
	private int aleCod;

	@Column(name="id_aler")
	private int idAler;

	//bi-directional one-to-one association to Alerta
	@OneToOne
	@JoinColumn(name="ale_cod", insertable=false, updatable=false )
	private Alerta alerta;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="alu_cod", referencedColumnName="alu_cod" , insertable=false, updatable=false),
		@JoinColumn(name="num_estado", referencedColumnName="num_estado" , insertable=false, updatable=false)
		})
	private Estado estado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usur_cod", insertable=false, updatable=false)
	private Usuario usuario;

	public AlertaParque() {
	}

	public int getAleCod() {
		return this.aleCod;
	}

	public void setAleCod(int aleCod) {
		this.aleCod = aleCod;
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