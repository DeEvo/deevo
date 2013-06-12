package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class NuevaPersonaResult implements Result {

	private String mensaje;
	private String usurCod;
	private String perPass;
	

	@SuppressWarnings("unused")
	private NuevaPersonaResult() {
		// For serialization only
	}

	public NuevaPersonaResult(String mensaje, String usurCod, String perPass) {
		this.mensaje = mensaje;
		this.usurCod = usurCod;
		this.perPass = perPass;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getUsurCod() {
		return usurCod;
	}

	public String getPerPass() {
		return perPass;
	}
	
	
}
