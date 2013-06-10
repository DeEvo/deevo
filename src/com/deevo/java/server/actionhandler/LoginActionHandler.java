package com.deevo.java.server.actionhandler;

import javax.persistence.EntityExistsException;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.Login;
import com.deevo.java.client.action.LoginResult;
import com.deevo.java.server.model.dao.LogIndao;
import com.deevo.java.server.model.dao.Personadao;
import com.deevo.java.share.LogIn;
import com.deevo.java.share.Usuario;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class LoginActionHandler implements ActionHandler<Login, LoginResult> {

	@Inject
	public LoginActionHandler() {
	}

	@Override
	public LoginResult execute(Login action, ExecutionContext context)
			throws ActionException {
		LogIn logIn = new LogIn();
		logIn.setUsuario(action.getUser());
		logIn.setPass(action.getPass());
		LogIndao logIndao = new LogIndao();
		try{
		if(logIn.equals(logIndao.retrieveLogIn(logIn.getUsuario())))	
			throw new ActionException("Usuario o Contraseña incorrectos");
		}catch(Throwable a){
			throw new ActionException("Solicitar ayuda al administrador");
		}
		return null;
	}

	@Override
	public void undo(Login action, LoginResult result, ExecutionContext context)
			throws ActionException {
	}

	@Override
	public Class<Login> getActionType() {
		return Login.class;
	}
}
