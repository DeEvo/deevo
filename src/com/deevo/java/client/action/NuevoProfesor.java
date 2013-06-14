package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevoProfesorResult;
import java.lang.String;
import java.util.List;

public class NuevoProfesor extends ActionImpl<NuevoProfesorResult> {

	private String per_dni;
	private String proDes;
	private String usser_admin;
	private List<String> Cursos;

	@SuppressWarnings("unused")
	private NuevoProfesor() {
		// For serialization only
	}

	public NuevoProfesor(String per_dni, String proDes, List<String> Cursos, String usser_admin) {
		this.per_dni = per_dni;
		this.proDes = proDes;
		this.Cursos = Cursos;
		this.usser_admin =usser_admin;
	}

	public String getPer_dni() {
		return per_dni;
	}

	public String getProDes() {
		return proDes;
	}

	public List getCursos() {
		return Cursos;
	}

	public String getUsser_admin() {
		return usser_admin;
	}
	
	
}
