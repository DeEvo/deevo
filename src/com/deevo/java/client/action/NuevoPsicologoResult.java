package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class NuevoPsicologoResult implements Result {

	private String mensaje;

	@SuppressWarnings("unused")
	private NuevoPsicologoResult() {
		// For serialization only
	}

	public NuevoPsicologoResult(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
