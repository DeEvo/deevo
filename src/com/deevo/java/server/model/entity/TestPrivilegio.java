package com.deevo.java.server.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEST_PRIVILEGIO database table.
 * 
 */
@Entity
@Table(name="TEST_PRIVILEGIO")
public class TestPrivilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TestPrivilegioPK id;

	//bi-directional many-to-one association to Privilegio
	@ManyToOne
	@JoinColumn(name="pri_cod")
	private Privilegio privilegio;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="test_cod")
	private Test test1;

	public TestPrivilegio() {
	}

	public TestPrivilegioPK getId() {
		return this.id;
	}

	public void setId(TestPrivilegioPK id) {
		this.id = id;
	}

	public Privilegio getPrivilegio() {
		return this.privilegio;
	}

	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}

	public Test getTest1() {
		return this.test1;
	}

	public void setTest1(Test test1) {
		this.test1 = test1;
	}

}