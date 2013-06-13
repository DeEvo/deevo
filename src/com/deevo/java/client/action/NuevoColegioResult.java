package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class NuevoColegioResult implements Result {

	private String mensaje;

	@SuppressWarnings("unused")
	private NuevoColegioResult() {
		// For serialization only
	}

	public NuevoColegioResult(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
