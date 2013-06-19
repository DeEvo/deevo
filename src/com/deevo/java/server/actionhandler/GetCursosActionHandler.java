package com.deevo.java.server.actionhandler;

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
		List<Curso> cursos = null;
		try {
			 cursos = cursodao.retrieveCursos();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new GetCursosResult(cursos);
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
