package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PSICOLOGO database table.
 * 
 */
@Entity
public class Psicologo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="psi_cod")
	private int psiCod;

	@Column(name="psi_dlab")
	private String psiDlab;

	@Temporal(TemporalType.DATE)
	@Column(name="psi_ing")
	private Date psiIng;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="psicologo")
	private List<Aula> aulas;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_dni")
	private Persona persona;

	public Psicologo() {
	}

	public int getPsiCod() {
		return this.psiCod;
	}

	public void setPsiCod(int psiCod) {
		this.psiCod = psiCod;
	}

	public String getPsiDlab() {
		return this.psiDlab;
	}

	public void setPsiDlab(String psiDlab) {
		this.psiDlab = psiDlab;
	}

	public Date getPsiIng() {
		return this.psiIng;
	}

	public void setPsiIng(Date psiIng) {
		this.psiIng = psiIng;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}