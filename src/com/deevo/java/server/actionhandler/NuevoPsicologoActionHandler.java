package com.deevo.java.server.actionhandler;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevoPsicologo;
import com.deevo.java.client.action.NuevoPsicologoResult;
import com.deevo.java.server.model.dao.AulaDao;
import com.deevo.java.server.model.dao.ColegioDao;
import com.deevo.java.server.model.dao.PersonaDao;
import com.deevo.java.server.model.dao.PsicologoDao;
import com.deevo.java.shared.Aula;
import com.deevo.java.shared.Colegio;
import com.deevo.java.shared.Persona;
import com.deevo.java.shared.Psicologo;
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
		ColegioDao colegiodao = new ColegioDao();
		AulaDao auladao = new AulaDao();
		Psicologo psicologo = new Psicologo();
		Colegio colegio = new Colegio();
		Persona persona = new Persona();
		Aula aula = new Aula();
		try {
			persona.setPerDni(action.getPer_dni());
			persona = personadao.retrievePersona(persona);
			psicologo.setPsiDes(action.getPro_des());
			psicologo.setPersona(persona);
			//REGISTRANDO EL COLEGIO
			psicologo = psicologodao.createPsicologo(psicologo);
			//registrado colegio
			colegio.setCodCol(Integer.valueOf(action.getCod_col()));
			colegio = colegiodao.retrieveColegio(colegio);
			psicologo.getColegios().add(colegio);
			psicologo = psicologodao.updatePsicologo(psicologo);
			//asignacionde aula
			if(action.getF()){
				aula.setCodAula(Integer.parseInt(action.getCod_aula()));
				aula = auladao.retrieveAula(aula);
				if(aula.getPsicologo() != null ){
					return new NuevoPsicologoResult("EXITO: Pisicologo creado / Aula ya contiene un Psicologo");
				}
				aula.setPsicologo(psicologo);
				aula = auladao.updateAula(aula);
				return new NuevoPsicologoResult("EXITO: Pisicologo creado / Pisicologo asignado a aula ");
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ActionException("Solicitar ayuda al administrador");
		}
		return new NuevoPsicologoResult("EXITO: Psicologo creado, sin ser asignado a alua");
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
