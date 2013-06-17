package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class NuevoPadreResult implements Result {

	private String Mensaje;

	@SuppressWarnings("unused")
	private NuevoPadreResult() {
		// For serialization only
	}

	public NuevoPadreResult(String Mensaje) {
		this.Mensaje = Mensaje;
	}

	public String getMensaje() {
		return Mensaje;
	}
}
