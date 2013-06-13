package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class NuevoPrivilegioResult implements Result {

	private String mensaje;

	@SuppressWarnings("unused")
	private NuevoPrivilegioResult() {
		// For serialization only
	}

	public NuevoPrivilegioResult(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
