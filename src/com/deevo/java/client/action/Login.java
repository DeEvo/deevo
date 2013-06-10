package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.LoginResult;
import java.lang.String;

public class Login extends ActionImpl<LoginResult> {

	private String user;
	private String pass;

	@SuppressWarnings("unused")
	public Login() {
		// For serialization only
	}

	public Login(String user, String pass) {
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
