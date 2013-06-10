package com.deevo.java.share;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Login
 *
 */

@Entity
@Table(name="LOGIN")

public class LogIn implements Serializable {

	
	private String usuario;
	private String pass;
	private static final long serialVersionUID = 1L;

	public LogIn() {
		super();
	}   
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}   
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
   
}
