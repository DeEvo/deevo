package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GRADO database table.
 * 
 */
@Entity
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_grado")
	private int codGrado;

	private String ciclo;

	@Column(name="desc_grado")
	private String descGrado;

	//bi-directional many-to-many association to Seccion
	@ManyToMany
	@JoinTable(
		name="GRADO_SECCION"
		, joinColumns={
			@JoinColumn(name="cod_grado")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cod_seccion")
			}
		)
	private List<Seccion> seccions;

	public Grado() {
	}

	public int getCodGrado() {
		return this.codGrado;
	}

	public void setCodGrado(int codGrado) {
		this.codGrado = codGrado;
	}

	public String getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getDescGrado() {
		return this.descGrado;
	}

	public void setDescGrado(String descGrado) {
		this.descGrado = descGrado;
	}

	public List<Seccion> getSeccions() {
		return this.seccions;
	}

	public void setSeccions(List<Seccion> seccions) {
		this.seccions = seccions;
	}

}