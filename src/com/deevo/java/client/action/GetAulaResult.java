package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;
import java.util.List;

public class GetAulaResult implements Result {

	private List<String> cod_seccion;
	private List<String> seccion_desc;
	private List<String> cod_grado;
	private List<String> grado_descrip;
	private List<String> cod_aula;

	@SuppressWarnings("unused")
	private GetAulaResult() {
		// For serialization only
	}

	public GetAulaResult(List<String> cod_seccion, List<String> seccion_desc, List<String> cod_grado,
			List<String> grado_descrip, List<String> cod_aula) {
		this.cod_seccion = cod_seccion;
		this.seccion_desc = seccion_desc;
		this.cod_grado = cod_grado;
		this.grado_descrip = grado_descrip;
		this.cod_aula = cod_aula;
	}

	public List<String> getCod_seccion() {
		return cod_seccion;
	}

	public List<String> getSeccion_desc() {
		return seccion_desc;
	}

	public List<String> getCod_aula() {
		return cod_grado;
	}

	public List<String> getAula_descrip() {
		return grado_descrip;
	}

	public List<String> getCod_grado() {
		return cod_grado;
	}

	public List<String> getGrado_descrip() {
		return grado_descrip;
	}
}
