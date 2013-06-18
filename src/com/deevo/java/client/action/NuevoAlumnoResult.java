package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class NuevoAlumnoResult implements Result {

	private String Mensaje;

	@SuppressWarnings("unused")
	private NuevoAlumnoResult() {
		// For serialization only
	}

	public NuevoAlumnoResult(String Mensaje) {
		this.Mensaje = Mensaje;
	}

	public String getMensaje() {
		return Mensaje;
	}
}
