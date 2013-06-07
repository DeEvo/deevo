package com.deevo.java.server.model.entity;

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

	//bi-directional many-to-one association to TestPrivilegio
	@OneToMany(mappedBy="privilegio")
	private List<TestPrivilegio> testPrivilegios;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="privilegios")
	private List<Usuario> usuarios;

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

	public List<TestPrivilegio> getTestPrivilegios() {
		return this.testPrivilegios;
	}

	public void setTestPrivilegios(List<TestPrivilegio> testPrivilegios) {
		this.testPrivilegios = testPrivilegios;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}