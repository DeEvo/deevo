package com.deevo.java.server.actionhandler;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevoPsicologo;
import com.deevo.java.client.action.NuevoPsicologoResult;
import com.deevo.java.server.model.dao.ColegioDao;
import com.deevo.java.server.model.dao.PersonaDao;
import com.deevo.java.server.model.dao.PsicologoDao;
import com.deevo.java.server.model.dao.UsuarioDao;
import com.deevo.java.share.Colegio;
import com.deevo.java.share.Persona;
import com.deevo.java.share.Privilegio;
import com.deevo.java.share.Psicologo;
import com.deevo.java.share.Usuario;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class NuevoPsicologoActionHandler implements
		ActionHandler<NuevoPsicologo, NuevoPsicologoResult> {

	@Inject
	public NuevoPsicologoActionHandler() {
	}

	@Override
	public NuevoPsicologoResult execute(NuevoPsicologo action,
			ExecutionContext context) throws ActionException {
		PersonaDao personadao = new PersonaDao();
		PsicologoDao psicologodao = new PsicologoDao();
		UsuarioDao usuariodao = new UsuarioDao();
		ColegioDao colegiodao = new ColegioDao();
		Psicologo psicologo = new Psicologo();
		Colegio colegio = new Colegio();
		Persona persona = new Persona();
		Usuario usuario = new Usuario();
		Privilegio privilegio = new Privilegio();
		persona.setPerDni(action.getPer_dni());
		try {
			persona = personadao.retrievePersona(persona);
			psicologo.setPsiDes(action.getPro_des());
			psicologo.setPersona(persona);
			//busqueda de colegio
			usuario.setUsurCod(action.getAdmin_user());
			usuario = usuariodao.retrieveUsuario(usuario);
			int i=0;
			while(i< usuario.getPrivilegios().size()){
				if(usuario.getPrivilegios().get(i).getPriFun() == "Administrar"){
					privilegio = usuario.getPrivilegios().get(i);
					i=usuario.getPrivilegios().size();
				}
				i++;
			}
			
			//psicologo.setColegios(psicologo.getColegios().add(e));
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ActionException("Solicitar ayuda al administrador");
		}
		
		
		return null;
	}

	@Override
	public void undo(NuevoPsicologo action, NuevoPsicologoResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<NuevoPsicologo> getActionType() {
		return NuevoPsicologo.class;
	}
}
