package com.deevo.java.server.actionhandler;

import javax.persistence.EntityExistsException;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.NuevoProfesor;
import com.deevo.java.client.action.NuevoProfesorResult;
import com.deevo.java.server.model.dao.ColegioDao;
import com.deevo.java.server.model.dao.ColegioProfesorDao;
import com.deevo.java.server.model.dao.CursoProfesorDao;
import com.deevo.java.server.model.dao.ProfesorDao;
import com.deevo.java.server.model.dao.UsuarioDao;
import com.deevo.java.share.Colegio;
import com.deevo.java.share.ColegioProfesor;
import com.deevo.java.share.ColegioProfesorPK;
import com.deevo.java.share.CursoProfesor;
import com.deevo.java.share.CursoProfesorPK;
import com.deevo.java.share.Persona;
import com.deevo.java.share.Privilegio;
import com.deevo.java.share.Profesor;
import com.deevo.java.share.Usuario;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class NuevoProfesorActionHandler implements
		ActionHandler<NuevoProfesor, NuevoProfesorResult> {

	@Inject
	public NuevoProfesorActionHandler() {
	}

	@Override
	public NuevoProfesorResult execute(NuevoProfesor action,
			ExecutionContext context) throws ActionException {
		
		ProfesorDao profesordao = new ProfesorDao();
		CursoProfesorDao cursoprofesordao = new CursoProfesorDao();
		ColegioProfesorDao colegioprofesordao = new ColegioProfesorDao();
		UsuarioDao usuariodao = new UsuarioDao();
		ColegioDao colegiodao = new ColegioDao();
		Profesor profesor = new Profesor();
		Persona persona = new Persona();
		Privilegio privilegio = new Privilegio();
		Colegio colegio = new Colegio();
		Usuario usuario = new Usuario();
		ColegioProfesor colegioprofesor = new ColegioProfesor();
		ColegioProfesorPK colegioprofesorpk = new ColegioProfesorPK();
		
		
		
		persona.setPerDni(action.getPer_dni());
		profesor.setProDes(action.getProDes());
		profesor.setPersona(persona);
		try {
			profesor = profesordao.createProfesor(profesor);
			int i=0;
			while(i< action.getCursos().size()){
				CursoProfesor cursoprofesor = new CursoProfesor();
				CursoProfesorPK cursoprofesorpk = new CursoProfesorPK();
				cursoprofesorpk.setCodCur(Integer.parseInt(action.getCursos().get(i).toString()));
				cursoprofesorpk.setProCod(profesor.getProCod());
				cursoprofesor.setId(cursoprofesorpk);
				cursoprofesordao.createCursoProfesor(cursoprofesor);
				i++;
			}
			
			usuario.setUsurCod(action.getUsser_admin());
			usuario = usuariodao.retrieveUsuario(usuario);
			i=0;
			while(i< usuario.getPrivilegios().size()){
				if(usuario.getPrivilegios().get(i).getPriFun() == "Administrar"){
					privilegio = usuario.getPrivilegios().get(i);
					i=usuario.getPrivilegios().size();
				}
				i++;
			}
			colegioprofesorpk.setCodCol(privilegio.getColegios().get(0).getCodCol());
			colegioprofesorpk.setProCod(profesor.getProCod());
			colegioprofesor.setId(colegioprofesorpk);
			colegioprofesor.setEstado((byte)1);
			colegioprofesordao.createColegioProfesor(colegioprofesor);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ActionException("Solicitar ayuda al administrador");
		}
		return new NuevoProfesorResult("EXITO");
	}

	@Override
	public void undo(NuevoProfesor action, NuevoProfesorResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<NuevoProfesor> getActionType() {
		return NuevoProfesor.class;
	}
}
