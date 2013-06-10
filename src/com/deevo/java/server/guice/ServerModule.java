package com.deevo.java.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;
import com.deevo.java.client.action.NuevaPersona;
import com.deevo.java.server.ActionHandler.NuevaPersonaActionHandler;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {

		bindHandler(NuevaPersona.class, NuevaPersonaActionHandler.class);
	}
}
