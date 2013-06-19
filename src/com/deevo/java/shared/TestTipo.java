package com.deevo.java.shared;

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

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="test_tipo_cod")
	private int testTipoCod;

	@Column(name="test_fis_herr")
	private String testFisHerr;

	@Column(name="test_fis_ubc")
	private String testFisUbc;

	@Column(name="test_periodo")
	private int testPeriodo;

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

	public int getTestPeriodo() {
		return this.testPeriodo;
	}

	public void setTestPeriodo(int testPeriodo) {
		this.testPeriodo = testPeriodo;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setTestTipo(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setTestTipo(null);

		return test;
	}

}