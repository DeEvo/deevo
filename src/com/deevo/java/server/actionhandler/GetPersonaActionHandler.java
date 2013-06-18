package com.deevo.java.server.actionhandler;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.GetPersona;
import com.deevo.java.client.action.GetPersonaResult;
import com.deevo.java.server.model.dao.PersonaDao;
import com.deevo.java.share.Persona;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class GetPersonaActionHandler implements
		ActionHandler<GetPersona, GetPersonaResult> {

	@Inject
	public GetPersonaActionHandler() {
	}

	@Override
	public GetPersonaResult execute(GetPersona action, ExecutionContext context)
			throws ActionException {
		
		 List<Persona> personalist = new ArrayList<Persona>();
		
		 if(action.getPer_dni() !=null){
				PersonaDao perdao = new PersonaDao();
				Persona persona = new Persona();
				persona.setPerDni(action.getPer_dni());
				
				try {
					persona = perdao.retrievePersona(persona);
					personalist.add(persona);	
				} catch (Throwable e) {
					e.printStackTrace();
					throw new ActionException("Solicitar ayuda al administrador");
				}
				
				return new GetPersonaResult( personalist, "EXITO");
			}
		 
		 if(action.getPer_mat() !=null && action.getPer_nom() !=null && action.getPer_pat() !=null){
			 PersonaDao p = new PersonaDao();
				try {
					
					personalist = p.retrievePersonasxperMatxperPatXperNom(action.getPer_mat(), action.getPer_pat(), action.getPer_nom());
					
				} catch (Throwable e) {
					e.printStackTrace();
					throw new ActionException("Solicitar ayuda al administrador");
				}
				return new GetPersonaResult( personalist, "EXITO");
		 }

			if(action.getPer_nom() == null){
				if(action.getPer_mat() == null){
					//solo paterno
					PersonaDao perdao = new PersonaDao();
					try {
					 personalist = perdao.retrievePersonasxperPat(action.getPer_pat());
					} catch (Throwable e) {
						e.printStackTrace();
						throw new ActionException("Solicitar ayuda al administrador");
					}
						return new GetPersonaResult( personalist, "EXITO");
				}else{
					if(action.getPer_pat() == null){
						//solo materno
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperMat(action.getPer_mat());
						
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( personalist, "EXITO");				
					}else{
						//paterno y materno
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperMatxperPat(action.getPer_mat(),action.getPer_pat());
							
							
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( personalist, "EXITO");
					}
				}
			}else{
				if(action.getPer_mat() == null){	
					if(action.getPer_pat() == null){
						//solo nombre
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperNom(action.getPer_nom());
							
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( personalist, "EXITO");
					}else{
						//nombre y paterno	
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperNomxperPat(action.getPer_nom(), action.getPer_pat());
							
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( personalist, "EXITO");
					}
					
					}else{
						//nombre y materno
						
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperNomxperMat(action.getPer_nom(), action.getPer_mat());
							
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( personalist, "EXITO");
						}
				}
	}

	@Override
	public void undo(GetPersona action, GetPersonaResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<GetPersona> getActionType() {
		return GetPersona.class;
	}
}
