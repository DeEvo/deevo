package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;

import java.util.List;
import java.lang.String;

public class GetPersonaResult implements Result {



	private List<String> dni;
	private List<String> nombre;
	private List<String> apparten;
	private List<String> apmatern;
	private String mensaje;
	private List<String> cod_user;

	@SuppressWarnings("unused")
	private GetPersonaResult() {
		// For serialization only
	}

	public GetPersonaResult( List<String> dni, List<String> nombre,List<String> apparten,List<String> apmatern,  
			List<String> cod_user, String mensaje) {

		this.mensaje = mensaje;
		this.dni = dni;
		this.nombre  = nombre;
		this.apparten = apparten;
		this.apmatern = apmatern;
		this.cod_user = cod_user;
	}


	public String getMensaje() {
		return mensaje;
	}

	public List<String> getDni() {
		return dni;
	}

	public List<String> getNombre() {
		return nombre;
	}

	public List<String> getApparten() {
		return apparten;
	}

	public List<String> getApmatern() {
		return apmatern;
	}

	public List<String> getCod_user() {
		return cod_user;
	}
}
