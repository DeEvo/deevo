package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PREGUNTA database table.
 * 
 */
@Entity
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="preg_cod")
	private int pregCod;

	@Column(name="pre_mas")
	private int preMas;

	@Column(name="pre_mat")
	private String preMat;

	@Column(name="pre_menos")
	private int preMenos;

	@Column(name="pre_resp")
	private String preResp;

	@Column(name="pre_txt")
	private String preTxt;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="test_cod")
	private Test test;

	//bi-directional many-to-one association to Respuesta
	@OneToMany(mappedBy="pregunta")
	private List<Respuesta> respuestas;

	public Pregunta() {
	}

	public int getPregCod() {
		return this.pregCod;
	}

	public void setPregCod(int pregCod) {
		this.pregCod = pregCod;
	}

	public int getPreMas() {
		return this.preMas;
	}

	public void setPreMas(int preMas) {
		this.preMas = preMas;
	}

	public String getPreMat() {
		return this.preMat;
	}

	public void setPreMat(String preMat) {
		this.preMat = preMat;
	}

	public int getPreMenos() {
		return this.preMenos;
	}

	public void setPreMenos(int preMenos) {
		this.preMenos = preMenos;
	}

	public String getPreResp() {
		return this.preResp;
	}

	public void setPreResp(String preResp) {
		this.preResp = preResp;
	}

	public String getPreTxt() {
		return this.preTxt;
	}

	public void setPreTxt(String preTxt) {
		this.preTxt = preTxt;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Respuesta addRespuesta(Respuesta respuesta) {
		getRespuestas().add(respuesta);
		respuesta.setPregunta(this);

		return respuesta;
	}

	public Respuesta removeRespuesta(Respuesta respuesta) {
		getRespuestas().remove(respuesta);
		respuesta.setPregunta(null);

		return respuesta;
	}

}