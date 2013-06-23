package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevoPsicologoResult;
import java.lang.String;

public class NuevoPsicologo extends ActionImpl<NuevoPsicologoResult> {

	private String pro_des;
	private String per_dni;
	private String cod_col;
	private String admin_user;

	@SuppressWarnings("unused")
	private NuevoPsicologo() {
		// For serialization only
	}

	public NuevoPsicologo(String pro_des, String per_dni, String admin_user, String cod_col) {
		this.pro_des = pro_des;
		this.per_dni = per_dni;
		this.admin_user = admin_user;
		this.cod_col =cod_col;
	}

	public String getPro_des() {
		return pro_des;
	}

	public String getPer_dni() {
		return per_dni;
	}

	public String getAdmin_user() {
		return admin_user;
	}

	public String getCod_col() {
		return cod_col;
	}
		
}