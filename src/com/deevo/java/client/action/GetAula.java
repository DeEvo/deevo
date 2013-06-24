package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.GetAulaResult;
import java.lang.String;

public class GetAula extends ActionImpl<GetAulaResult> {

	private String cod_col;

	@SuppressWarnings("unused")
	private GetAula() {
		// For serialization only
	}

	public GetAula(String cod_col) {
		this.cod_col = cod_col;
	}

	public String getCod_col() {
		return cod_col;
	}
}
