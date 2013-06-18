package com.deevo.java.server.actionhandler;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevoAlumno;
import com.deevo.java.client.action.NuevoAlumnoResult;
import com.deevo.java.server.model.dao.AlumnoDao;
import com.deevo.java.server.model.dao.FamiliaDao;
import com.deevo.java.server.model.dao.PersonaDao;
import com.deevo.java.share.Alumno;
import com.deevo.java.share.Familia;
import com.deevo.java.share.FamiliaPK;
import com.deevo.java.share.Persona;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class NuevoAlumnoActionHandler implements
		ActionHandler<NuevoAlumno, NuevoAlumnoResult> {

	@Inject
	public NuevoAlumnoActionHandler() {
	}

	@Override
	public NuevoAlumnoResult execute(NuevoAlumno action, ExecutionContext context)
			throws ActionException {
		PersonaDao personadao = new PersonaDao();
		Persona persona = new Persona();
		AlumnoDao alumnodao = new AlumnoDao();
		Alumno alumno = new Alumno();
		FamiliaDao familiadao = new FamiliaDao();
		Familia familia = new Familia();
		FamiliaPK familiapk = new FamiliaPK();
		try {
			persona.setPerDir(action.getDni());
			persona = personadao.retrievePersona(persona);
			alumno.setPersona(persona);
			alumno.setCodMinedu(action.getCodMinedu());
			alumno = alumnodao.createAlumno(alumno);
			//registro de padres
			if(action.getDni_madre() != null){
				familiapk.setPerA(action.getDni_padre());
				familiapk.setPerB(persona.getPerDni());
				familia.setId(familiapk);
				familia.setFamDes("Padre");
				familiadao.createFamilia(familia);
			}
			if(action.getDni_padre() != null){
				familiapk.setPerA(action.getDni_madre());
				familiapk.setPerB(persona.getPerDni());
				familia.setId(familiapk);
				familia.setFamDes("Madre");
				familiadao.createFamilia(familia);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ActionException("Solicitar ayuda al administrador");
		}
		return new NuevoAlumnoResult("EXITO");
	}

	@Override
	public void undo(NuevoAlumno action, NuevoAlumnoResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<NuevoAlumno> getActionType() {
		return NuevoAlumno.class;
	}
}
