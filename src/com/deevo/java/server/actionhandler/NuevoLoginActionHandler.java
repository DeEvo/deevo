package com.deevo.java.server.actionhandler;


import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;

import com.deevo.java.client.action.NuevoLogin;
import com.deevo.java.server.model.dao.UsuarioDao;
import com.deevo.java.share.Usuario;
import com.google.inject.Inject;
import com.deevo.java.client.action.NuevoLoginResult;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class NuevoLoginActionHandler implements ActionHandler<NuevoLogin, NuevoLoginResult> {

	@Inject
	public NuevoLoginActionHandler() {
	}

	@Override
	public NuevoLoginResult execute(NuevoLogin action, ExecutionContext context)
			throws ActionException {
		Usuario user = new Usuario();
		user.setUsurCod(action.getUser());
		user.setPerPass(action.getPass());
		UsuarioDao userdao = new  UsuarioDao();
		try{
		if(user.equals(userdao.retrieveUsuario(user)))	
			throw new ActionException("Usuario o Contraseña incorrectos");
		}catch(Throwable a){
			throw new ActionException("Solicitar ayuda al administrador");
		}
		return null;
	}

	@Override
	public void undo(NuevoLogin action, NuevoLoginResult result, ExecutionContext context)
			throws ActionException {
	}

	@Override
	public Class<NuevoLogin> getActionType() {
		return NuevoLogin.class;
	}
}
