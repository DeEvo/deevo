package com.deevo.java.client.action;

import com.deevo.java.shared.Curso;
import com.gwtplatform.dispatch.shared.Result;
import java.util.List;

public class GetCursosResult implements Result {

	private List<String> codCur;
	private List<String> curDes;
	private List<String> curNom;
	private List<String> curTip;

	@SuppressWarnings("unused")
	private GetCursosResult() {
		// For serialization only
	}

	public GetCursosResult(List<String> codCur,
			List<String> curDes, List<String> curNom, List<String> curTip) {
		this.codCur = codCur;
		this.curDes = curDes;
		this.curNom = curNom;
		this.curTip = curTip;
	}


	public List<String> getCodCur() {
		return codCur;
	}

	public List<String> getCurDes() {
		return curDes;
	}

	public List<String> getCurNom() {
		return curNom;
	}

	public List<String> getCurTip() {
		return curTip;
	}
}
