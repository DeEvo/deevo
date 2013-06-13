package com.deevo.java.server.actionhandler;

import javax.persistence.EntityExistsException;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevoColegio;
import com.deevo.java.client.action.NuevoColegioResult;
import com.deevo.java.server.model.dao.ColegioDao;
import com.deevo.java.share.Colegio;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class NuevoColegioActionHandler implements
		ActionHandler<NuevoColegio, NuevoColegioResult> {

	@Inject
	public NuevoColegioActionHandler() {
	}

	@Override
	public NuevoColegioResult execute(NuevoColegio action, ExecutionContext context)
			throws ActionException {
		Colegio colegio = new Colegio();
		
		
		colegio.setColDir(action.getCol_dir());
		colegio.setColNom(action.getCol_nom());
		colegio.setColTelf(action.getCol_telf());
		colegio.setColUgel(action.getCol_ugel());
		colegio.setColSector(action.getCol_sector());
		colegio.setColDistri(action.getCol_distri());
		
		ColegioDao coldao = new ColegioDao();
		
		try {
			coldao.createColegio(colegio);
		}catch(EntityExistsException a){
			throw new ActionException("La Persona ya existe "+a.getMessage());
		}catch(Throwable a){
			throw new ActionException("Solicitar ayuda al administrador");
		}
		return new NuevoColegioResult("Exito");
	}

	@Override
	public void undo(NuevoColegio action, NuevoColegioResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<NuevoColegio> getActionType() {
		return NuevoColegio.class;
	}
}
