package com.deevo.java.server.actionhandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.client.action.GetAula;
import com.deevo.java.client.action.GetAulaResult;
import com.deevo.java.server.model.dao.AulaDao;
import com.deevo.java.server.model.dao.ColegioDao;
import com.deevo.java.server.model.dao.GradoDao;
import com.deevo.java.server.model.dao.GradoSeccionDao;
import com.deevo.java.server.model.dao.PeriodoAcademicoDao;
import com.deevo.java.server.model.dao.SeccionDao;
import com.deevo.java.shared.Aula;
import com.deevo.java.shared.Colegio;
import com.deevo.java.shared.Grado;
import com.deevo.java.shared.GradoSeccion;
import com.deevo.java.shared.PeriodoAcademico;
import com.deevo.java.shared.Seccion;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class GetAulaActionHandler implements
		ActionHandler<GetAula, GetAulaResult> {

	@Inject
	public GetAulaActionHandler() {
	}

	@Override
	public GetAulaResult execute(GetAula action, ExecutionContext context)
			throws ActionException {
		
		List<Aula> aulalist = new ArrayList<Aula>();
		AulaDao auladao = new AulaDao();
		Colegio colegio = new Colegio();
		ColegioDao colegiodao = new ColegioDao();
		PeriodoAcademico peraca = new PeriodoAcademico();
		PeriodoAcademicoDao peracadao = new PeriodoAcademicoDao();
		Grado grado = new Grado();
		GradoDao gradodao = new GradoDao();
		Seccion seccion = new Seccion();
		SeccionDao secciondao = new SeccionDao();
		List<String> cod_seccion = new ArrayList<String>();
		List<String> seccion_desc = new ArrayList<String>();
		List<String> cod_grado = new ArrayList<String>();
		List<String> grado_descrip = new ArrayList<String>();
		List<String> cod_aula = new ArrayList<String>();
		try {
			colegio.setCodCol(Integer.parseInt(action.getCod_col()));
			colegio = colegiodao.retrieveColegio(colegio);
			peraca = peracadao.retrievePeriodoAcademicoActual(new Date()).get(0);
			aulalist = auladao.retrieveAulaxCOLxPER(colegio, peraca);
			int i=0;
			while(i< aulalist.size()){
				grado.setCodGrado(aulalist.get(i).getGradoSeccion().getId().getCodGrado());
				grado = gradodao.retrieveGrado(grado);
				seccion.setCodSeccion(aulalist.get(i).getGradoSeccion().getId().getCodSeccion());
				seccion = secciondao.retrieveSeccion(seccion) ;
				cod_seccion.add(String.valueOf(seccion.getCodSeccion()));
				seccion_desc.add(seccion.getDescSec());
				cod_grado.add(String.valueOf(grado.getCodGrado()));
				grado_descrip.add(grado.getDescGrado());
				cod_aula.add(String.valueOf(aulalist.get(i).getCodAula()));
				i++;
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new GetAulaResult(cod_seccion, seccion_desc, cod_grado, grado_descrip, cod_aula);
	}

	@Override
	public void undo(GetAula action, GetAulaResult result, ExecutionContext context)
			throws ActionException {
	}

	@Override
	public Class<GetAula> getActionType() {
		return GetAula.class;
	}
}
