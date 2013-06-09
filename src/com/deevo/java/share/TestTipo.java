package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEST_TIPO database table.
 * 
 */
@Entity
@Table(name="TEST_TIPO")
public class TestTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="test_tipo_cod")
	private int testTipoCod;

	@Column(name="test_fis_herr")
	private String testFisHerr;

	@Column(name="test_fis_ubc")
	private String testFisUbc;

	@Column(name="test_per_acad")
	private String testPerAcad;

	@Column(name="test_psi_nivel")
	private String testPsiNivel;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="testTipo")
	private List<Test> tests;

	public TestTipo() {
	}

	public int getTestTipoCod() {
		return this.testTipoCod;
	}

	public void setTestTipoCod(int testTipoCod) {
		this.testTipoCod = testTipoCod;
	}

	public String getTestFisHerr() {
		return this.testFisHerr;
	}

	public void setTestFisHerr(String testFisHerr) {
		this.testFisHerr = testFisHerr;
	}

	public String getTestFisUbc() {
		return this.testFisUbc;
	}

	public void setTestFisUbc(String testFisUbc) {
		this.testFisUbc = testFisUbc;
	}

	public String getTestPerAcad() {
		return this.testPerAcad;
	}

	public void setTestPerAcad(String testPerAcad) {
		this.testPerAcad = testPerAcad;
	}

	public String getTestPsiNivel() {
		return this.testPsiNivel;
	}

	public void setTestPsiNivel(String testPsiNivel) {
		this.testPsiNivel = testPsiNivel;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

}