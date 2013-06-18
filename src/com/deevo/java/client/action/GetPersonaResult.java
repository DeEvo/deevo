package com.deevo.java.client.action;

import com.deevo.java.share.Persona;
import com.gwtplatform.dispatch.shared.Result;

import java.util.List;
import java.lang.String;

public class GetPersonaResult implements Result {


	private List<Persona> persona ;
	private String mensaje;

	@SuppressWarnings("unused")
	private GetPersonaResult() {
		// For serialization only
	}

	public GetPersonaResult(List<Persona> persona , String mensaje) {

		this.mensaje = mensaje;
		this.persona = persona;
	}


	public String getMensaje() {
		return mensaje;
	}

	public List<Persona> getPersona() {
		return persona;
	}
	
	
}
