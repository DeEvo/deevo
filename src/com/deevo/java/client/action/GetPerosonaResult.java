package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;
import java.lang.Integer;
import java.util.Date;

public class GetPerosonaResult implements Result {

	private String per_dni;
	private String per_nom;
	private Integer per_telf;
	private Date per_nac;
	private Integer per_cel;
	private String per_estc;
	private String per_email;
	private String per_dir;
	private String per_pat;
	private String per_mat;
	private Date per_ing;

	@SuppressWarnings("unused")
	private GetPerosonaResult() {
		// For serialization only
	}

	public GetPerosonaResult(String per_dni, String per_nom, Integer per_telf,
			Date per_nac, Integer per_cel, String per_estc, String per_email,
			String per_dir, String per_pat, String per_mat, Date per_ing) {
		this.per_dni = per_dni;
		this.per_nom = per_nom;
		this.per_telf = per_telf;
		this.per_nac = per_nac;
		this.per_cel = per_cel;
		this.per_estc = per_estc;
		this.per_email = per_email;
		this.per_dir = per_dir;
		this.per_pat = per_pat;
		this.per_mat = per_mat;
		this.per_ing = per_ing;
	}

	public String getPer_dni() {
		return per_dni;
	}

	public String getPer_nom() {
		return per_nom;
	}

	public Integer getPer_telf() {
		return per_telf;
	}

	public Date getPer_nac() {
		return per_nac;
	}

	public Integer getPer_cel() {
		return per_cel;
	}

	public String getPer_estc() {
		return per_estc;
	}

	public String getPer_email() {
		return per_email;
	}

	public String getPer_dir() {
		return per_dir;
	}

	public String getPer_pat() {
		return per_pat;
	}

	public String getPer_mat() {
		return per_mat;
	}

	public Date getPer_ing() {
		return per_ing;
	}
}
