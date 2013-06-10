package com.deevo.java.server.action;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevaPersona;
import com.deevo.java.client.action.NuevaPersonaResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class NuevaPersonaActionHandler implements
		ActionHandler<NuevaPersona, NuevaPersonaResult> {

	@Inject
	public NuevaPersonaActionHandler() {
	}

	@Override
	public NuevaPersonaResult execute(NuevaPersona action, ExecutionContext context)
			throws ActionException {
		return null;
	}

	@Override
	public void undo(NuevaPersona action, NuevaPersonaResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<NuevaPersona> getActionType() {
		return NuevaPersona.class;
	}
}
