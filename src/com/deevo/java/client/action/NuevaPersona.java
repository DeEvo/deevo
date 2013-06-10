package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevaPersonaResult;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

public class NuevaPersona extends ActionImpl<NuevaPersonaResult> {

	private Integer dni;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private Date fechanac;
	private Integer telefono;
	private Integer celular;
	private String direccion;
	private String email;

	@SuppressWarnings("unused")
	private NuevaPersona() {
		// For serialization only
	}

	public NuevaPersona(Integer dni, String nombre, String apaterno,
			String amaterno, Date fechanac, Integer telefono, Integer celular,
			String direccion, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.fechanac = fechanac;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
		this.email = email;
	}

	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApaterno() {
		return apaterno;
	}

	public String getAmaterno() {
		return amaterno;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public Integer getCelular() {
		return celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getEmail() {
		return email;
	}
}
