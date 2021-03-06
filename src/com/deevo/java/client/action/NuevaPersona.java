package com.deevo.java.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import com.deevo.java.client.action.NuevaPersonaResult;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

public class NuevaPersona extends ActionImpl<NuevaPersonaResult> {

	private String dni;
	private String nombre;
	private String apmatern;
	private String appatern;
	private Date fechanac;
	private Integer telefono;
	private Integer celular;
	private String direccion;
	private String email;
	private String estc;
	private Boolean flag_usuario;
	private String sexo;
	

	@Override
	public boolean isSecured() {
		return false;
	}
	
	@SuppressWarnings("unused")
	private NuevaPersona() {
		// For serialization only
	}

	public NuevaPersona(String dni, String nombre, String appatern,
			String apmatern, Date fechanac, Integer telefono, Integer celular,
			String direccion, String email, String estc, Boolean flag_usuario, String sexo) {
		this.dni = dni;
		this.nombre = nombre;
		this.appatern = appatern;
		this.apmatern = apmatern;
		this.fechanac = fechanac;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
		this.email = email;
		this.estc = estc;
		this.sexo = sexo;
		this.flag_usuario = flag_usuario;
		
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApmatern() {
		return apmatern;
	}

	public String getAppatern() {
		return appatern;
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

	public String getEstc() {
		return estc;
	}

	public String getSexo() {
		return sexo;
	}
	

	public Boolean getFlag_usuario() {
		return flag_usuario;
	}
	
	

	
}
