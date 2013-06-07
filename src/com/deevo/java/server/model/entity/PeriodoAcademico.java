package com.deevo.java.server.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PERIODO_ACADEMICO database table.
 * 
 */
@Entity
@Table(name="PERIODO_ACADEMICO")
public class PeriodoAcademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_per")
	private int codPer;

	private int annio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="per_fin")
	private Date perFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="per_inicio")
	private Date perInicio;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="periodoAcademico1")
	private List<Aula> aulas1;

	public PeriodoAcademico() {
	}

	public int getCodPer() {
		return this.codPer;
	}

	public void setCodPer(int codPer) {
		this.codPer = codPer;
	}

	public int getAnnio() {
		return this.annio;
	}

	public void setAnnio(int annio) {
		this.annio = annio;
	}

	public Date getPerFin() {
		return this.perFin;
	}

	public void setPerFin(Date perFin) {
		this.perFin = perFin;
	}

	public Date getPerInicio() {
		return this.perInicio;
	}

	public void setPerInicio(Date perInicio) {
		this.perInicio = perInicio;
	}

	public List<Aula> getAulas1() {
		return this.aulas1;
	}

	public void setAulas1(List<Aula> aulas1) {
		this.aulas1 = aulas1;
	}

}
