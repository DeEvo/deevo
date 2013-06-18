package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevoPadreResult;
import java.lang.String;

public class NuevoPadre extends ActionImpl<NuevoPadreResult> {

	private String dni;
	private String admin_user;

	@SuppressWarnings("unused")
	private NuevoPadre() {
		// For serialization only
	}

	public NuevoPadre(String dni, String admin_user) {
		this.dni = dni;
		this.admin_user = admin_user;
	}

	public String getDni() {
		return dni;
	}

	public String getAdmin_user() {
		return admin_user;
	}
}
