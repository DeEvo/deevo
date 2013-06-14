package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.util.List;
import java.lang.String;

public class GetPersonaResult implements Result {


	private List<String> appaterno;
	private List<String> apmaterno;
	private List<String> nombre;
	private List<String> dni;
	private String mensaje;

	@SuppressWarnings("unused")
	private GetPersonaResult() {
		// For serialization only
	}

	public GetPersonaResult(List<String> appaterno,  List<String> apmaterno , List<String> nombre, 
			List<String> dni, String mensaje) {

		this.mensaje = mensaje;
		this.appaterno = appaterno;
		this.apmaterno = apmaterno;
		this.nombre = nombre;
		this.dni = dni;
	}


	public String getMensaje() {
		return mensaje;
	}
}
