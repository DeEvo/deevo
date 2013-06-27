package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTADO_TIPO database table.
 * 
 */
@Entity
@Table(name="ESTADO_TIPO")
public class EstadoTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_est_tipo")
	private int codEstTipo;

	private String descrip;

	@Column(name="pun_max")
	private int punMax;

	@Column(name="pun_min")
	private int punMin;

	//bi-directional many-to-one association to Estado
	@OneToMany(mappedBy="estadoTipo")
	private List<Estado> estados;

	public EstadoTipo() {
	}

	public int getCodEstTipo() {
		return this.codEstTipo;
	}

	public void setCodEstTipo(int codEstTipo) {
		this.codEstTipo = codEstTipo;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public int getPunMax() {
		return this.punMax;
	}

	public void setPunMax(int punMax) {
		this.punMax = punMax;
	}

	public int getPunMin() {
		return this.punMin;
	}

	public void setPunMin(int punMin) {
		this.punMin = punMin;
	}

	public List<Estado> getEstados() {
		return this.estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado addEstado(Estado estado) {
		getEstados().add(estado);
		estado.setEstadoTipo(this);

		return estado;
	}

	public Estado removeEstado(Estado estado) {
		getEstados().remove(estado);
		estado.setEstadoTipo(null);

		return estado;
	}

}