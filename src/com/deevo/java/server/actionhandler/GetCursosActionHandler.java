package com.deevo.java.server.actionhandler;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.deevo.java.shared.Curso;
import com.deevo.java.client.action.GetCursos;
import com.deevo.java.client.action.GetCursosResult;
import com.deevo.java.server.model.dao.CursoDao;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class GetCursosActionHandler implements
		ActionHandler<GetCursos, GetCursosResult> {

	@Inject
	public GetCursosActionHandler() {
	}

	@Override
	public GetCursosResult execute(GetCursos action, ExecutionContext context)
			throws ActionException {
		CursoDao cursodao = new CursoDao();
		List<Curso> cursos = new ArrayList<Curso>();
		List<String> codCur = new ArrayList<String>();
		List<String> curDes = new ArrayList<String>();
		List<String> curNom = new ArrayList<String>();
		List<String> curTip = new ArrayList<String>();
		
		try {
			 cursos = cursodao.retrieveCursosxNombre(action.getCur_nom());
			 int i =0;
			 while(i< cursos.size()){
				 codCur.add(String.valueOf(cursos.get(i).getCodCur()));
				 curDes.add(cursos.get(i).getCurDes());
				 curNom.add(cursos.get(i).getCurNom());
				 curTip.add(cursos.get(i).getCurTip());
				 i++;
			 }
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new GetCursosResult(codCur, curDes, curNom, curTip);
	}

	@Override
	public void undo(GetCursos action, GetCursosResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<GetCursos> getActionType() {
		return GetCursos.class;
	}
}
