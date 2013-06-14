package com.deevo.java.client.action;

import com.deevo.java.share.Curso;
import com.gwtplatform.dispatch.shared.Result;
import java.util.List;

public class GetCursosResult implements Result {

	private List<Curso> Cursos;

	@SuppressWarnings("unused")
	private GetCursosResult() {
		// For serialization only
	}

	public GetCursosResult(List<Curso> Cursos) {
		this.Cursos = Cursos;
	}

	public List<Curso> getCursos() {
		return Cursos;
	}
}
