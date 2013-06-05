package model;

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

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="periodoAcademico2")
	private List<Aula> aulas2;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="periodoAcademico3")
	private List<Aula> aulas3;

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

	public List<Aula> getAulas2() {
		return this.aulas2;
	}

	public void setAulas2(List<Aula> aulas2) {
		this.aulas2 = aulas2;
	}

	public List<Aula> getAulas3() {
		return this.aulas3;
	}

	public void setAulas3(List<Aula> aulas3) {
		this.aulas3 = aulas3;
	}

}