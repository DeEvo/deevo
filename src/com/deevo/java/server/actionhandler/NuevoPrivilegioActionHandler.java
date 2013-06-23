package com.deevo.java.server.actionhandler;

import javax.persistence.EntityExistsException;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevoPrivilegio;
import com.deevo.java.client.action.NuevoPrivilegioResult;
import com.deevo.java.server.model.dao.PrivilegioDao;
import com.deevo.java.shared.Privilegio;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class NuevoPrivilegioActionHandler implements
		ActionHandler<NuevoPrivilegio, NuevoPrivilegioResult> {

	@Inject
	public NuevoPrivilegioActionHandler() {
	}

	@Override
	public NuevoPrivilegioResult execute(NuevoPrivilegio action,
			ExecutionContext context) throws ActionException {
		 Privilegio privilegio = new Privilegio();
		 
		privilegio.setPriDes(action.getPri_des());
		privilegio.setPriFun(action.getPri_fun());
		privilegio.setPriNom(action.getPri_nom());
		
		PrivilegioDao privilegiodao = new PrivilegioDao();
		
		try {
			privilegiodao.createPrivilegio(privilegio);
		}catch(EntityExistsException a){
			throw new ActionException("La Persona ya existe "+a.getMessage());
		}catch(Throwable a){
			throw new ActionException("Solicitar ayuda al administrador");
		}
		return new NuevoPrivilegioResult("EXITO");
	}

	@Override
	public void undo(NuevoPrivilegio action, NuevoPrivilegioResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<NuevoPrivilegio> getActionType() {
		return NuevoPrivilegio.class;
	}
}
