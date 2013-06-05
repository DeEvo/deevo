package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CURSO database table.
 * 
 */
@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_cur")
	private int codCur;

	@Column(name="cur_des")
	private String curDes;

	@Column(name="cur_nom")
	private String curNom;

	@Column(name="cur_tip")
	private String curTip;

	//bi-directional many-to-one association to CursoProfesor
	@OneToMany(mappedBy="curso")
	private List<CursoProfesor> cursoProfesors;

	public Curso() {
	}

	public int getCodCur() {
		return this.codCur;
	}

	public void setCodCur(int codCur) {
		this.codCur = codCur;
	}

	public String getCurDes() {
		return this.curDes;
	}

	public void setCurDes(String curDes) {
		this.curDes = curDes;
	}

	public String getCurNom() {
		return this.curNom;
	}

	public void setCurNom(String curNom) {
		this.curNom = curNom;
	}

	public String getCurTip() {
		return this.curTip;
	}

	public void setCurTip(String curTip) {
		this.curTip = curTip;
	}

	public List<CursoProfesor> getCursoProfesors() {
		return this.cursoProfesors;
	}

	public void setCursoProfesors(List<CursoProfesor> cursoProfesors) {
		this.cursoProfesors = cursoProfesors;
	}

}