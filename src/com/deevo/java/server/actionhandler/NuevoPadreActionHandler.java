package com.deevo.java.server.actionhandler;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevoPadre;
import com.deevo.java.client.action.NuevoPadreResult;
import com.deevo.java.server.model.dao.PadreFamiliaDao;
import com.deevo.java.server.model.dao.PersonaDao;
import com.deevo.java.shared.PadreFamilia;
import com.deevo.java.shared.Persona;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class NuevoPadreActionHandler implements
		ActionHandler<NuevoPadre, NuevoPadreResult> {

	@Inject
	public NuevoPadreActionHandler() {
	}

	@Override
	public NuevoPadreResult execute(NuevoPadre action, ExecutionContext context)
			throws ActionException {
		Persona persona = new Persona();
		PersonaDao personadao = new PersonaDao();
		PadreFamilia padrefamilia = new PadreFamilia();
		PadreFamiliaDao padrefamiliadao = new PadreFamiliaDao();

		try {
			persona.setPerDni(action.getDni());
			persona = personadao.retrievePersona(persona);
			padrefamilia.setPersona(persona);
			if(action.getPadre_bio()){
				padrefamilia.setPadBio((byte)1);
			}else{
				padrefamilia.setPadBio((byte)0);
			}
			padrefamilia.setPadCant(0);
			padrefamiliadao.createPadreFamilia(padrefamilia);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ActionException("Solicitar ayuda al administrador");
		}
		
		return new NuevoPadreResult("EXITO, no olviddar de registar ALUMNOS");
	}

	@Override
	public void undo(NuevoPadre action, NuevoPadreResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<NuevoPadre> getActionType() {
		return NuevoPadre.class;
	}
}
