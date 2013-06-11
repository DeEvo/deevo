package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevoLoginResult;
import java.lang.String;

public class NuevoLogin extends ActionImpl<NuevoLoginResult> {

	private String user;
	private String pass;

	//@SuppressWarnings("unused")
	public NuevoLogin() {
		// For serialization only
	}

	public NuevoLogin(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}
}
