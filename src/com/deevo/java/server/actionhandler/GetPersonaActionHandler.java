package com.deevo.java.server.actionhandler;

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

	@SuppressWarnings("null")
	@Override
	public GetPersonaResult execute(GetPersona action, ExecutionContext context)
			throws ActionException {
		
		 List<String> appaterno = null;
		 List<String> apmaterno = null;
		 List<String> nombre = null;
		 List<String> dni = null;
		
		 if(action.getPer_dni() !=null){
				PersonaDao perdao = new PersonaDao();
				Persona persona = new Persona();
				persona.setPerDni(action.getPer_dni());
				
				try {
					persona = perdao.retrievePersona(persona);
				} catch (Throwable e) {
					e.printStackTrace();
				}
				appaterno.add(persona.getPerPat());
				apmaterno.add(persona.getPerMat());
				nombre.add(persona.getPerNom());
				dni.add(persona.getPerDni());
				return new GetPersonaResult( appaterno, apmaterno, nombre, dni, "EXITO");
			}
		 
		 if(action.getPer_mat() !=null && action.getPer_nom() !=null && action.getPer_pat() !=null){
			 PersonaDao p = new PersonaDao();
				try {
					
					List<Persona> personalist = p.retrievePersonasxperMatxperPatXperNom(action.getPer_mat(), action.getPer_pat(), action.getPer_nom());
					int i = 0;
					while(i<personalist.size()){
						appaterno.add(personalist.get(i).getPerPat());
						apmaterno.add(personalist.get(i).getPerMat());
						nombre.add(personalist.get(i).getPerNom());
						dni.add(personalist.get(i).getPerDni());					
						i++;
					}
				} catch (Throwable e) {
					e.printStackTrace();
				}
				return new GetPersonaResult( appaterno, apmaterno, nombre, dni, "EXITO");
		 }

			if(action.getPer_nom() == null){
				if(action.getPer_mat() == null){
					//solo paterno
					PersonaDao perdao = new PersonaDao();
					try {
						List<Persona> personalist = perdao.retrievePersonasxperPat(action.getPer_pat());
						int i = 0;
						while(i<personalist.size()){
							appaterno.add(personalist.get(i).getPerPat());
							apmaterno.add(personalist.get(i).getPerMat());
							nombre.add(personalist.get(i).getPerNom());
							dni.add(personalist.get(i).getPerDni());					
							i++;
						}
					} catch (Throwable e) {
						e.printStackTrace();
					}
						return new GetPersonaResult( appaterno, apmaterno, nombre, dni, "EXITO");
				}else{
					if(action.getPer_pat() == null){
						//solo materno
						PersonaDao perdao = new PersonaDao();
						try {
							List<Persona> personalist = perdao.retrievePersonasxperMat(action.getPer_mat());
							int i = 0;
							while(i<personalist.size()){
								appaterno.add(personalist.get(i).getPerPat());
								apmaterno.add(personalist.get(i).getPerMat());
								nombre.add(personalist.get(i).getPerNom());
								dni.add(personalist.get(i).getPerDni());					
								i++;
							}
						} catch (Throwable e) {
							e.printStackTrace();
						}
						return new GetPersonaResult( appaterno, apmaterno, nombre, dni, "EXITO");				
					}else{
						//paterno y materno
						PersonaDao perdao = new PersonaDao();
						try {
							List<Persona> personalist = perdao.retrievePersonasxperMatxperPat(action.getPer_mat(),action.getPer_pat());
							int i = 0;
							while(i<personalist.size()){
								appaterno.add(personalist.get(i).getPerPat());
								apmaterno.add(personalist.get(i).getPerMat());
								nombre.add(personalist.get(i).getPerNom());
								dni.add(personalist.get(i).getPerDni());					
								i++;
							}
						} catch (Throwable e) {
							e.printStackTrace();
						}
						return new GetPersonaResult( appaterno, apmaterno, nombre, dni, "EXITO");
					}
				}
			}else{
				if(action.getPer_mat() == null){	
					if(action.getPer_pat() == null){
						//solo nombre
						PersonaDao perdao = new PersonaDao();
						try {
							List<Persona> personalist = perdao.retrievePersonasxperNom(action.getPer_nom());
							int i = 0;
							while(i<personalist.size()){
								appaterno.add(personalist.get(i).getPerPat());
								apmaterno.add(personalist.get(i).getPerMat());
								nombre.add(personalist.get(i).getPerNom());
								dni.add(personalist.get(i).getPerDni());					
								i++;
							}
						} catch (Throwable e) {
							e.printStackTrace();
						}
						return new GetPersonaResult( appaterno, apmaterno, nombre, dni, "EXITO");
					}else{
						//nombre y paterno	
						PersonaDao perdao = new PersonaDao();
						try {
							List<Persona> personalist = perdao.retrievePersonasxperNomxperPat(action.getPer_nom(), action.getPer_pat());
							int i = 0;
							while(i<personalist.size()){
								appaterno.add(personalist.get(i).getPerPat());
								apmaterno.add(personalist.get(i).getPerMat());
								nombre.add(personalist.get(i).getPerNom());
								dni.add(personalist.get(i).getPerDni());					
								i++;
							}
						} catch (Throwable e) {
							e.printStackTrace();
						}
						return new GetPersonaResult( appaterno, apmaterno, nombre, dni, "EXITO");
					}
					
					}else{
						//nombre y materno
						
						PersonaDao perdao = new PersonaDao();
						try {
							List<Persona> personalist = perdao.retrievePersonasxperNomxperMat(action.getPer_nom(), action.getPer_mat());
							int i = 0;
							while(i<personalist.size()){
								appaterno.add(personalist.get(i).getPerPat());
								apmaterno.add(personalist.get(i).getPerMat());
								nombre.add(personalist.get(i).getPerNom());
								dni.add(personalist.get(i).getPerDni());					
								i++;
							}
						} catch (Throwable e) {
							e.printStackTrace();
						}
						return new GetPersonaResult( appaterno, apmaterno, nombre, dni, "EXITO");
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
