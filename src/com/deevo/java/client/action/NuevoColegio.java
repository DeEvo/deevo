package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevoColegioResult;
import java.lang.String;
import java.lang.Integer;

public class NuevoColegio extends ActionImpl<NuevoColegioResult> {

	private String col_nom;
	private String col_dir;
	private Integer col_telf;
	private String col_ugel;
	private String col_sector;
	private String col_distri;

	@SuppressWarnings("unused")
	private NuevoColegio() {
		// For serialization only
	}
	
	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
	public NuevoColegio(String col_nom, String col_dir, Integer col_telf,
			String col_ugel, String col_sector, String col_distri) {
		this.col_nom = col_nom;
		this.col_dir = col_dir;
		this.col_telf = col_telf;
		this.col_ugel = col_ugel;
		this.col_sector = col_sector;
		this.col_distri = col_distri;
	}

	public String getCol_nom() {
		return col_nom;
	}

	public String getCol_dir() {
		return col_dir;
	}

	public Integer getCol_telf() {
		return col_telf;
	}

	public String getCol_ugel() {
		return col_ugel;
	}

	public String getCol_sector() {
		return col_sector;
	}

	public String getCol_distri() {
		return col_distri;
	}
}
