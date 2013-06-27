package com.deevo.java.shared;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_per")
	private int codPer;

	@Column(name="per_des")
	private String perDes;

	@Temporal(TemporalType.DATE)
	@Column(name="per_fin")
	private Date perFin;

	@Temporal(TemporalType.DATE)
	@Column(name="per_inicio")
	private Date perInicio;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="periodoAcademico")
	private List<Aula> aulas;

	public PeriodoAcademico() {
	}

	public int getCodPer() {
		return this.codPer;
	}

	public void setCodPer(int codPer) {
		this.codPer = codPer;
	}

	public String getPerDes() {
		return this.perDes;
	}

	public void setPerDes(String perDes) {
		this.perDes = perDes;
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

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setPeriodoAcademico(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setPeriodoAcademico(null);

		return aula;
	}

}