package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevoPrivilegioResult;
import java.lang.String;

public class NuevoPrivilegio extends ActionImpl<NuevoPrivilegioResult> {

	private String pri_nom;
	private String pri_fun;
	private String pri_des;

	@SuppressWarnings("unused")
	private NuevoPrivilegio() {
		// For serialization only
	}
	
	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
	public NuevoPrivilegio(String pri_nom, String pri_fun, String pri_des) {
		this.pri_nom = pri_nom;
		this.pri_fun = pri_fun;
		this.pri_des = pri_des;
	}

	public String getPri_nom() {
		return pri_nom;
	}

	public String getPri_fun() {
		return pri_fun;
	}

	public String getPri_des() {
		return pri_des;
	}
}
