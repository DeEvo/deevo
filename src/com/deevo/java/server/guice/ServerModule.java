package com.deevo.java.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;
import com.deevo.java.client.action.NuevaPersona;
import com.deevo.java.client.action.Login;
import com.deevo.java.server.actionhandler.LoginActionHandler;
import com.deevo.java.server.actionhandler.NuevaPersonaActionHandler;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {

		bindHandler(NuevaPersona.class, NuevaPersonaActionHandler.class);

		bindHandler(Login.class, LoginActionHandler.class);
	}
}
