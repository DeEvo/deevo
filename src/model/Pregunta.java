package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PREGUNTA database table.
 * 
 */
@Entity
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="preg_cod")
	private int pregCod;

	@Column(name="ban_des")
	private String banDes;

	@Column(name="ban_mat")
	private String banMat;

	@Column(name="ban_pre")
	private String banPre;

	@Column(name="ban_punt")
	private int banPunt;

	@Column(name="ban_resp")
	private String banResp;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="test_cod")
	private Test test;

	//bi-directional many-to-one association to Respuesta
	@OneToMany(mappedBy="pregunta")
	private List<Respuesta> respuestas;

	public Pregunta() {
	}

	public int getPregCod() {
		return this.pregCod;
	}

	public void setPregCod(int pregCod) {
		this.pregCod = pregCod;
	}

	public String getBanDes() {
		return this.banDes;
	}

	public void setBanDes(String banDes) {
		this.banDes = banDes;
	}

	public String getBanMat() {
		return this.banMat;
	}

	public void setBanMat(String banMat) {
		this.banMat = banMat;
	}

	public String getBanPre() {
		return this.banPre;
	}

	public void setBanPre(String banPre) {
		this.banPre = banPre;
	}

	public int getBanPunt() {
		return this.banPunt;
	}

	public void setBanPunt(int banPunt) {
		this.banPunt = banPunt;
	}

	public String getBanResp() {
		return this.banResp;
	}

	public void setBanResp(String banResp) {
		this.banResp = banResp;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

}