package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.GetPersonaResult;


import java.lang.String;


public class GetPersona extends ActionImpl<GetPersonaResult> {

	private String per_nom;
	private String per_pat;
	private String per_mat;
	private String per_dni;

	
	public void setPer_dni(String per_dni) {
		this.per_dni = per_dni;
	}  

	@SuppressWarnings("unused")
	private GetPersona() {
		// For serialization only
	}

	public GetPersona(String per_nom, String per_pat, String per_mat, String per_dni) {
		this.per_nom = per_nom;
		this.per_pat = per_pat;
		this.per_mat = per_mat;
		this.per_dni = per_dni;
	}

	public String getPer_nom() {
		return per_nom;
	}

	public String getPer_pat() {
		return per_pat;
	}

	public String getPer_mat() {
		return per_mat;
	}

	public String getPer_dni() {
		return per_dni;
	}
}
