package com.deevo.java.server.actionhandler;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.GetPersona;
import com.deevo.java.client.action.GetPersonaResult;
import com.deevo.java.server.model.dao.PersonaDao;
import com.deevo.java.shared.Persona;
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
		 List<String> dni = new ArrayList<String>(); 
		List<String> nombre = new ArrayList<String>();
			 List<String> apparten = new ArrayList<String>();
			List<String> apmatern = new ArrayList<String>();
		 if(! action.getPer_dni().isEmpty()){
				PersonaDao perdao = new PersonaDao();
				Persona persona = new Persona();
				persona.setPerDni(action.getPer_dni());
				try {
					persona = perdao.retrievePersona(persona);
					personalist.add(persona);
					int i = 0;
					while(i< personalist.size()){
						dni.add(personalist.get(i).getPerDni());
						nombre.add(personalist.get(i).getPerNom());
						apparten.add(personalist.get(i).getPerPat());
						apmatern.add(personalist.get(i).getPerMat());
						i++;
					}
					
				} catch (Throwable e) {
					e.printStackTrace();
					throw new ActionException("Solicitar ayuda al administrador");
				}
				
				return new GetPersonaResult( dni,nombre,apparten,apmatern, "EXITO");
			}
		 
		 if(action.getPer_mat() !="" && action.getPer_nom() !="" && action.getPer_pat() !=""){
			 // paterno, materno, nombre
			 PersonaDao p = new PersonaDao();
				try {
					
					personalist = p.retrievePersonasxperMatxperPatXperNom(action.getPer_mat(), action.getPer_pat(), action.getPer_nom());
					int i = 0;
					while(i< personalist.size()){
						dni.add(personalist.get(i).getPerDni());
						nombre.add(personalist.get(i).getPerNom());
						apparten.add(personalist.get(i).getPerPat());
						apmatern.add(personalist.get(i).getPerMat());
						i++;
					}
				} catch (Throwable e) {
					e.printStackTrace();
					throw new ActionException("Solicitar ayuda al administrador");
				}
				return new GetPersonaResult( dni,nombre,apparten,apmatern, "EXITO");
		 }

			if(action.getPer_nom() == ""){
				if(action.getPer_mat() == ""){
					//solo paterno
					PersonaDao perdao = new PersonaDao();
					try {
					 personalist = perdao.retrievePersonasxperPat(action.getPer_pat());
					 int i = 0;
						while(i< personalist.size()){
							dni.add(personalist.get(i).getPerDni());
							nombre.add(personalist.get(i).getPerNom());
							apparten.add(personalist.get(i).getPerPat());
							apmatern.add(personalist.get(i).getPerMat());
							i++;
						}
					} catch (Throwable e) {
						e.printStackTrace();
						throw new ActionException("Solicitar ayuda al administrador");
					}
					return new GetPersonaResult( dni,nombre,apparten,apmatern, "EXITO");
				}else{
					if(action.getPer_pat() == ""){
						//solo materno
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperMat(action.getPer_mat());
							int i = 0;
							while(i< personalist.size()){
								dni.add(personalist.get(i).getPerDni());
								nombre.add(personalist.get(i).getPerNom());
								apparten.add(personalist.get(i).getPerPat());
								apmatern.add(personalist.get(i).getPerMat());
								i++;
							}
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( dni,nombre,apparten,apmatern, "EXITO");			
					}else{
						//paterno y materno
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperMatxperPat(action.getPer_mat(),action.getPer_pat());
							int i = 0;
							while(i< personalist.size()){
								dni.add(personalist.get(i).getPerDni());
								nombre.add(personalist.get(i).getPerNom());
								apparten.add(personalist.get(i).getPerPat());
								apmatern.add(personalist.get(i).getPerMat());
								i++;
							}
							
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( dni,nombre,apparten,apmatern, "EXITO");
					}
				}
			}else{
				if(action.getPer_mat() == ""){	
					if(action.getPer_pat() == ""){
						//solo nombre
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperNom(action.getPer_nom());
							int i = 0;
							while(i< personalist.size()){
								dni.add(personalist.get(i).getPerDni());
								nombre.add(personalist.get(i).getPerNom());
								apparten.add(personalist.get(i).getPerPat());
								apmatern.add(personalist.get(i).getPerMat());
								i++;
							}
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( dni,nombre,apparten,apmatern, "EXITO");
					}else{
						//nombre y paterno	
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperNomxperPat(action.getPer_nom(), action.getPer_pat());
							int i = 0;
							while(i< personalist.size()){
								dni.add(personalist.get(i).getPerDni());
								nombre.add(personalist.get(i).getPerNom());
								apparten.add(personalist.get(i).getPerPat());
								apmatern.add(personalist.get(i).getPerMat());
								i++;
							}
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( dni,nombre,apparten,apmatern, "EXITO");
					}
					
					}else{
						//nombre y materno
						
						PersonaDao perdao = new PersonaDao();
						try {
							personalist = perdao.retrievePersonasxperNomxperMat(action.getPer_nom(), action.getPer_mat());
							int i = 0;
							while(i< personalist.size()){
								dni.add(personalist.get(i).getPerDni());
								nombre.add(personalist.get(i).getPerNom());
								apparten.add(personalist.get(i).getPerPat());
								apmatern.add(personalist.get(i).getPerMat());	
								i++;
							}
						} catch (Throwable e) {
							e.printStackTrace();
							throw new ActionException("Solicitar ayuda al administrador");
						}
						return new GetPersonaResult( dni,nombre,apparten,apmatern, "EXITO");
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
