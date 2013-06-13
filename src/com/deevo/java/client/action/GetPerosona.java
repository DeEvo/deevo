package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.GetPerosonaResult;
import java.lang.String;

public class GetPerosona extends ActionImpl<GetPerosonaResult> {

	private String usur_cod;

	@SuppressWarnings("unused")
	private GetPerosona() {
		// For serialization only
	}

	public GetPerosona(String usur_cod) {
		this.usur_cod = usur_cod;
	}

	public String getUsur_cod() {
		return usur_cod;
	}
}
