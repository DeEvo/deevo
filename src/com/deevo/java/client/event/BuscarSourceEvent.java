package com.deevo.java.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import java.lang.String;
import com.google.gwt.event.shared.HasHandlers;

public class BuscarSourceEvent extends
		GwtEvent<BuscarSourceEvent.BuscarSourceHandler> {

	public static Type<BuscarSourceHandler> TYPE = new Type<BuscarSourceHandler>();
	private String Origen;

	public interface BuscarSourceHandler extends EventHandler {
		void onBuscarSource(BuscarSourceEvent event);
	}

	public BuscarSourceEvent(String Origen) {
		this.Origen = Origen;
	}

	public String getOrigen() {
		return Origen;
	}

	@Override
	protected void dispatch(BuscarSourceHandler handler) {
		handler.onBuscarSource(this);
	}

	@Override
	public Type<BuscarSourceHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<BuscarSourceHandler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source, String Origen) {
		source.fireEvent(new BuscarSourceEvent(Origen));
	}
}
