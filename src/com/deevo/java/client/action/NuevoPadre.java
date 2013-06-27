package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevoPadreResult;
import java.lang.String;

public class NuevoPadre extends ActionImpl<NuevoPadreResult> {

	private String dni;
	private String admin_user;
	private Boolean padre_bio;

	@SuppressWarnings("unused")
	private NuevoPadre() {
		// For serialization only
	}

	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
	public NuevoPadre(String dni, String admin_user, Boolean padre_bio) {
		this.dni = dni;
		this.admin_user = admin_user;
		this.padre_bio = padre_bio;
	}

	public String getDni() {
		return dni;
	}

	public String getAdmin_user() {
		return admin_user;
	}

	public Boolean getPadre_bio() {
		return padre_bio;
	}
}
