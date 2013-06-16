package com.deevo.java.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import java.lang.String;
import com.google.gwt.event.shared.HasHandlers;

public class MostrarPopupEvent extends
		GwtEvent<MostrarPopupEvent.MostrarPopupHandler> {

	public static Type<MostrarPopupHandler> TYPE = new Type<MostrarPopupHandler>();
	private String valor;
	private String dni;
	private String nombres;
	private String apaterno;
	private String amaterno;

	public interface MostrarPopupHandler extends EventHandler {
		void onMostrarPopup(MostrarPopupEvent event);
	}

	public MostrarPopupEvent(String valor, String dni, String nombres,
			String apaterno, String amaterno) {
		this.valor = valor;
		this.dni = dni;
		this.nombres = nombres;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
	}

	public String getValor() {
		return valor;
	}

	public String getDni() {
		return dni;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApaterno() {
		return apaterno;
	}

	public String getAmaterno() {
		return amaterno;
	}

	@Override
	protected void dispatch(MostrarPopupHandler handler) {
		handler.onMostrarPopup(this);
	}

	@Override
	public Type<MostrarPopupHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<MostrarPopupHandler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source, String valor, String dni,
			String nombres, String apaterno, String amaterno) {
		source.fireEvent(new MostrarPopupEvent(valor, dni, nombres, apaterno,
				amaterno));
	}
}
