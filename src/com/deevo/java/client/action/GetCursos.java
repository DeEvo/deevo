package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.GetCursosResult;

public class GetCursos extends ActionImpl<GetCursosResult> {

	private String cur_nom;
	
	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
	public GetCursos() {

	}
	
	public GetCursos(String cur_nom) {
		this.cur_nom = cur_nom;
	}
	
	public String getCur_nom() {
		return cur_nom;
	}

	
}
