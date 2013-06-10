package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class NuevaPersonaResult implements Result {

	private String mensaje;

	@SuppressWarnings("unused")
	private NuevaPersonaResult() {
		// For serialization only
	}

	public NuevaPersonaResult(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
