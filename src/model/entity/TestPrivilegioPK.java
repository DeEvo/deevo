package model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TEST_PRIVILEGIO database table.
 * 
 */
@Embeddable
public class TestPrivilegioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="test_cod")
	private int testCod;

	@Column(name="pri_cod")
	private int priCod;

	public TestPrivilegioPK() {
	}
	public int getTestCod() {
		return this.testCod;
	}
	public void setTestCod(int testCod) {
		this.testCod = testCod;
	}
	public int getPriCod() {
		return this.priCod;
	}
	public void setPriCod(int priCod) {
		this.priCod = priCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TestPrivilegioPK)) {
			return false;
		}
		TestPrivilegioPK castOther = (TestPrivilegioPK)other;
		return 
			(this.testCod == castOther.testCod)
			&& (this.priCod == castOther.priCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.testCod;
		hash = hash * prime + this.priCod;
		
		return hash;
	}
}