package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ALUMNO database table.
 * 
 */
@Entity
@Table(name="ALUMNO")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alu_cod")
	private int aluCod;

	@Column(name="cod_minedu")
	private String codMinedu;

	//bi-directional many-to-many association to Aula
	@ManyToMany
	@JoinTable(
		name="ALUMNO_AULA"
		, joinColumns={
			@JoinColumn(name="alu_cod")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cod_aula")
			}
		)
	private List<Aula> aulas;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_dni")
	private Persona persona;

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

	public String getCodMinedu() {
		return this.codMinedu;
	}

	public void setCodMinedu(String codMinedu) {
		this.codMinedu = codMinedu;
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

	public List<Estado> getEstados() {
		return this.estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado addEstado(Estado estado) {
		getEstados().add(estado);
		estado.setAlumno(this);

		return estado;
	}

	public Estado removeEstado(Estado estado) {
		getEstados().remove(estado);
		estado.setAlumno(null);

		return estado;
	}

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public Registro addRegistro(Registro registro) {
		getRegistros().add(registro);
		registro.setAlumno(this);

		return registro;
	}

	public Registro removeRegistro(Registro registro) {
		getRegistros().remove(registro);
		registro.setAlumno(null);

		return registro;
	}

	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Respuesta addRespuesta(Respuesta respuesta) {
		getRespuestas().add(respuesta);
		respuesta.setAlumno(this);

		return respuesta;
	}

	public Respuesta removeRespuesta(Respuesta respuesta) {
		getRespuestas().remove(respuesta);
		respuesta.setAlumno(null);

		return respuesta;
	}

}