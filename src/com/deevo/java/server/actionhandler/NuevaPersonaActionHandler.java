package com.deevo.java.server.actionhandler;

import java.util.Date;

import javax.persistence.EntityExistsException;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevaPersona;
import com.deevo.java.client.action.NuevaPersonaResult;
import com.deevo.java.server.model.dao.Personadao;
import com.deevo.java.share.Persona;
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
			Persona persona = new Persona();
			persona.setPerDni(String.valueOf(action.getDni()));
			persona.setPerNom(action.getNombre());
			persona.setPerPat(action.getAppatern());
			persona.setPerMat(action.getApmatern());
			persona.setPerDir(action.getDireccion());
			persona.setPerCel(action.getCelular());
			persona.setPerTelf(action.getTelefono());
			persona.setPerNac(action.getFechanac());
			persona.setPerEmail(action.getEmail());
			persona.setPerEstc(action.getEstc());
			persona.setPerIng(new Date());
	
			Personadao perdao = new Personadao();
			try{
			perdao.createPersona(persona);
			}catch(EntityExistsException a){
				throw new ActionException("La Persona ya existe "+a.getMessage());
			}catch(Throwable a){
				throw new ActionException("Solicitar ayuda al administrador");
			}
			
		return new NuevaPersonaResult("Exito");
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
