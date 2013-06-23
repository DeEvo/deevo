package com.deevo.java.server.actionhandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import javax.persistence.EntityExistsException;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevaPersona;
import com.deevo.java.client.action.NuevaPersonaResult;
import com.deevo.java.server.model.dao.PersonaDao;
import com.deevo.java.server.model.dao.UsuarioDao;
import com.deevo.java.shared.Persona;
import com.deevo.java.shared.Usuario;
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
			persona.setPerDni(action.getDni());
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
			persona.setSexo(action.getSexo());
			PersonaDao perdao = new PersonaDao();
			try{
			perdao.createPersona(persona);
			}catch(EntityExistsException a){
				throw new ActionException("La Persona ya existe "+a.getMessage());
			}catch(SQLException a){	
				throw new ActionException("La Persona ya existe ");
			}catch(Throwable a){
				throw new ActionException("Solicitar ayuda al administrador");
			}
				
			if(action.getFlag_usuario()){
				Usuario user = new Usuario();
				
				user.setUsurCod(action.getNombre().substring(0, 2).toLowerCase() + action.getAppatern().toLowerCase() + action.getApmatern().substring(0, 2).toLowerCase());
				user.setPerPass(action.getDni());
				user.setPersona(persona);
								
				UsuarioDao userdao = new UsuarioDao();
				while(userdao.existeUsuario(user)){
					Random r = new Random();
					user.setUsurCod( action.getNombre().substring(0, 2).toLowerCase() + action.getAppatern().toLowerCase() + action.getApmatern().substring(0, 2).toLowerCase() +  (char)(r.nextInt(26)+97));
				}
				try {
					userdao.createUsuario(user);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ActionException("La Persona ya existe ");
				}
				return new NuevaPersonaResult("Exito", user.getUsurCod() , user.getPerPass());
			}			
		return new NuevaPersonaResult("Exito", null , null);
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