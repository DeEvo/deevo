package com.deevo.java.shared;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the METODO_CALIFICACION database table.
 * 
 */
@Entity
@Table(name="METODO_CALIFICACION")
public class MetodoCalificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="met_cod")
	private int metCod;

	@Column(name="met_des")
	private String metDes;

	@Column(name="met_nom")
	private String metNom;

	@Column(name="met_pod")
	private String metPod;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="metodoCalificacion")
	private List<Test> tests;

	public MetodoCalificacion() {
	}

	public int getMetCod() {
		return this.metCod;
	}

	public void setMetCod(int metCod) {
		this.metCod = metCod;
	}

	public String getMetDes() {
		return this.metDes;
	}

	public void setMetDes(String metDes) {
		this.metDes = metDes;
	}

	public String getMetNom() {
		return this.metNom;
	}

	public void setMetNom(String metNom) {
		this.metNom = metNom;
	}

	public String getMetPod() {
		return this.metPod;
	}

	public void setMetPod(String metPod) {
		this.metPod = metPod;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setMetodoCalificacion(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setMetodoCalificacion(null);

		return test;
	}

}