package com.deevo.java.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;
import com.deevo.java.client.action.NuevaPersona;
import com.deevo.java.client.action.NuevoLogin;
import com.deevo.java.server.actionhandler.NuevoLoginActionHandler;
import com.deevo.java.server.actionhandler.NuevaPersonaActionHandler;
import com.deevo.java.client.action.NuevoColegio;
import com.deevo.java.server.actionhandler.NuevoColegioActionHandler;
import com.deevo.java.client.action.NuevoPrivilegio;
import com.deevo.java.server.actionhandler.NuevoPrivilegioActionHandler;
import com.deevo.java.client.action.GetPersona;
import com.deevo.java.server.actionhandler.GetPersonaActionHandler;
import com.deevo.java.client.action.GetCursos;
import com.deevo.java.server.actionhandler.GetCursosActionHandler;
import com.deevo.java.client.action.NuevoProfesor;
import com.deevo.java.server.actionhandler.NuevoProfesorActionHandler;
import com.deevo.java.client.action.NuevoPsicologo;
import com.deevo.java.server.actionhandler.NuevoPsicologoActionHandler;
import com.deevo.java.client.action.NuevoAlumno;
import com.deevo.java.server.actionhandler.NuevoAlumnoActionHandler;
import com.deevo.java.client.action.NuevoPadre;
import com.deevo.java.server.actionhandler.NuevoPadreActionHandler;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {

		bindHandler(NuevaPersona.class, NuevaPersonaActionHandler.class);

		bindHandler(NuevoLogin.class, NuevoLoginActionHandler.class);

		bindHandler(NuevoColegio.class, NuevoColegioActionHandler.class);

		bindHandler(NuevoPrivilegio.class, NuevoPrivilegioActionHandler.class);

		bindHandler(GetPersona.class, GetPersonaActionHandler.class);

		bindHandler(GetCursos.class, GetCursosActionHandler.class);

		bindHandler(NuevoProfesor.class, NuevoProfesorActionHandler.class);

		bindHandler(NuevoPsicologo.class, NuevoPsicologoActionHandler.class);

		bindHandler(NuevoAlumno.class, NuevoAlumnoActionHandler.class);

		bindHandler(NuevoPadre.class, NuevoPadreActionHandler.class);
	}
}
