package com.deevo.java.share;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOGIN database table.
 * 
 */
@Entity
@Table(name="LOGIN")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String user;

	@Column(name="user_pass")
	private String userPass;

	@Column(name="usur_cod")
	private int usurCod;

	public Login() {
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public int getUsurCod() {
		return this.usurCod;
	}

	public void setUsurCod(int usurCod) {
		this.usurCod = usurCod;
	}

}