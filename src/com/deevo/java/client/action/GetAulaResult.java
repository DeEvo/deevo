package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;
import java.util.List;

public class GetAulaResult implements Result {

	private List<String> seccion_desc;
	private List<String> grado_descrip;
	private List<String> cod_aula;
	private List<String> grado_descrip_filtro; 

	@SuppressWarnings("unused")
	private GetAulaResult() {
		// For serialization only
	}

	public GetAulaResult( List<String> seccion_desc,
			List<String> grado_descrip, List<String> cod_aula, List<String> grado_descrip_filtro) {
		this.seccion_desc = seccion_desc;
		this.grado_descrip = grado_descrip;
		this.cod_aula = cod_aula;
		this.grado_descrip_filtro = grado_descrip_filtro;
	}
	public List<String> getSeccion_desc() {
		return seccion_desc;
	}

	public List<String> getCod_aula() {
		return cod_aula;
	}

	public List<String> getAula_descrip() {
		return grado_descrip;
	}


	public List<String> getGrado_descrip() {
		return grado_descrip;
	}

	public List<String> getGrado_descrip_filtro() {
		return grado_descrip_filtro;
	}
}
