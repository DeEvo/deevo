package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class NuevoProfesorResult implements Result {

	private String Mensaje;

	@SuppressWarnings("unused")
	private NuevoProfesorResult() {
		// For serialization only
	}

	public NuevoProfesorResult(String Mensaje) {
		this.Mensaje = Mensaje;
	}

	public String getMensaje() {
		return Mensaje;
	}
}
