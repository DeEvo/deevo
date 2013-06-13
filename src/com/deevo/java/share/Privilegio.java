package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRIVILEGIOS database table.
 * 
 */
@Entity
@Table(name="PRIVILEGIOS")
public class Privilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pri_cod")
	private int priCod;

	@Column(name="pri_des")
	private String priDes;

	@Column(name="pri_fun")
	private String priFun;

	@Column(name="pri_nom")
	private String priNom;

	//bi-directional many-to-many association to Colegio
	@ManyToMany
	@JoinTable(
		name="COLEGIO_PRIVILEGIO"
		, joinColumns={
			@JoinColumn(name="pri_cod")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cod_col")
			}
		)
	private List<Colegio> colegios;

	public Privilegio() {
	}

	public int getPriCod() {
		return this.priCod;
	}

	public void setPriCod(int priCod) {
		this.priCod = priCod;
	}

	public String getPriDes() {
		return this.priDes;
	}

	public void setPriDes(String priDes) {
		this.priDes = priDes;
	}

	public String getPriFun() {
		return this.priFun;
	}

	public void setPriFun(String priFun) {
		this.priFun = priFun;
	}

	public String getPriNom() {
		return this.priNom;
	}

	public void setPriNom(String priNom) {
		this.priNom = priNom;
	}

	public List<Colegio> getColegios() {
		return this.colegios;
	}

	public void setColegios(List<Colegio> colegios) {
		this.colegios = colegios;
	}

}