package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SESION database table.
 * 
 */
@Entity
public class Sesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ses")
	private int idSes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="frcha_fin")
	private Date frchaFin;

	//bi-directional many-to-one association to Registro
	@OneToMany(mappedBy="sesion")
	private List<Registro> registros;

	//bi-directional many-to-one association to Colegio
	@ManyToOne
	@JoinColumn(name="cod_col")
	private Colegio colegio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usur_cod")
	private Usuario usuario;

	public Sesion() {
	}

	public int getIdSes() {
		return this.idSes;
	}

	public void setIdSes(int idSes) {
		this.idSes = idSes;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFrchaFin() {
		return this.frchaFin;
	}

	public void setFrchaFin(Date frchaFin) {
		this.frchaFin = frchaFin;
	}

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public Registro addRegistro(Registro registro) {
		getRegistros().add(registro);
		registro.setSesion(this);

		return registro;
	}

	public Registro removeRegistro(Registro registro) {
		getRegistros().remove(registro);
		registro.setSesion(null);

		return registro;
	}

	public Colegio getColegio() {
		return this.colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}