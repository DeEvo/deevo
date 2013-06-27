package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevoAlumnoResult;
import java.lang.String;

public class NuevoAlumno extends ActionImpl<NuevoAlumnoResult> {

	private String dni;
	private String dni_padre;
	private String dni_madre;
	private String codMinedu;
	private String admin_user;
	private String cod_aula;
	
	@SuppressWarnings("unused")
	private NuevoAlumno() {
		// For serialization only
	}

	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
	public NuevoAlumno(String dni, String dni_padre, String dni_madre,String codMinedu, String admin_user) {
		this.dni = dni;
		this.codMinedu = codMinedu;
		this.admin_user = admin_user;
		this.dni_padre = dni_padre;
		this.dni_madre = dni_madre;
	}

	public String getDni() {
		return dni;
	}

	public String getCodMinedu() {
		return codMinedu;
	}

	public String getAdmin_user() {
		return admin_user;
	}

	public String getDni_padre() {
		return dni_padre;
	}

	public String getDni_madre() {
		return dni_madre;
	}

	public String getCod_aula() {
		return cod_aula;
	}
}
