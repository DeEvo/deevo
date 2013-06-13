package com.deevo.java.server.actionhandler;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.GetPerosona;
import com.deevo.java.client.action.GetPerosonaResult;
import com.deevo.java.server.model.dao.UsuarioDao;
import com.deevo.java.share.Usuario;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class GetPerosonaActionHandler implements
		ActionHandler<GetPerosona, GetPerosonaResult> {

	@Inject
	public GetPerosonaActionHandler() {
	}

	@Override
	public GetPerosonaResult execute(GetPerosona action, ExecutionContext context)
			throws ActionException {
		UsuarioDao usuariodao = new UsuarioDao();
		Usuario usuario =new Usuario();
		usuario.setUsurCod(action.getUsur_cod());
		try {
			usuario = usuariodao.retrieveUsuario(usuario);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ActionException("Solicitar ayuda al administrador");
		}
		return new GetPerosonaResult(usuario.getPersona().getPerDni(), usuario.getPersona().getPerNom(),
				usuario.getPersona().getPerTelf(), usuario.getPersona().getPerNac(), usuario.getPersona().getPerCel(), 
				usuario.getPersona().getPerEstc(), usuario.getPersona().getPerEmail(), usuario.getPersona().getPerDir(),
				usuario.getPersona().getPerPat(), usuario.getPersona().getPerMat(), usuario.getPersona().getPerIng());
	}

	@Override
	public void undo(GetPerosona action, GetPerosonaResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<GetPerosona> getActionType() {
		return GetPerosona.class;
	}
}
