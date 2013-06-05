package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ALUMNO database table.
 * 
 */
@Entity
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="alu_cod")
	private int aluCod;

	//bi-directional many-to-one association to PadreFamilia
	@ManyToOne
	@JoinColumn(name="pad_cod")
	private PadreFamilia padreFamilia;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_dni")
	private Persona persona;

	//bi-directional many-to-one association to AlumnoAula
	@OneToMany(mappedBy="alumno1")
	private List<AlumnoAula> alumnoAulas1;

	//bi-directional many-to-one association to AlumnoAula
	@OneToMany(mappedBy="alumno2")
	private List<AlumnoAula> alumnoAulas2;

	//bi-directional many-to-one association to Estado
	@OneToMany(mappedBy="alumno")
	private List<Estado> estados;

	//bi-directional many-to-one association to Registro
	@OneToMany(mappedBy="alumno")
	private List<Registro> registros;

	//bi-directional many-to-one association to Respuesta
	@OneToMany(mappedBy="alumno")
	private List<Respuesta> respuestas;

	public Alumno() {
	}

	public int getAluCod() {
		return this.aluCod;
	}

	public void setAluCod(int aluCod) {
		this.aluCod = aluCod;
	}

	public PadreFamilia getPadreFamilia() {
		return this.padreFamilia;
	}

	public void setPadreFamilia(PadreFamilia padreFamilia) {
		this.padreFamilia = padreFamilia;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<AlumnoAula> getAlumnoAulas1() {
		return this.alumnoAulas1;
	}

	public void setAlumnoAulas1(List<AlumnoAula> alumnoAulas1) {
		this.alumnoAulas1 = alumnoAulas1;
	}

	public List<AlumnoAula> getAlumnoAulas2() {
		return this.alumnoAulas2;
	}

	public void setAlumnoAulas2(List<AlumnoAula> alumnoAulas2) {
		this.alumnoAulas2 = alumnoAulas2;
	}

	public List<Estado> getEstados() {
		return this.estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

}