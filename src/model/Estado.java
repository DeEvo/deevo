package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTADOS database table.
 * 
 */
@Entity
@Table(name="ESTADOS")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstadoPK id;

	@Column(name="est_des")
	private String estDes;

	@Column(name="est_grav")
	private String estGrav;

	@Column(name="set_nom")
	private String setNom;

	@Column(name="set_psi")
	private int setPsi;

	//bi-directional many-to-one association to AlertaParque
	@OneToMany(mappedBy="estado")
	private List<AlertaParque> alertaParques;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="alu_cod")
	private Alumno alumno;

	//bi-directional many-to-one association to EstadoTipo
	@ManyToOne
	@JoinColumn(name="cod_est_tipo")
	private EstadoTipo estadoTipo;

	//bi-directional many-to-one association to Respuesta
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="alu_cod", referencedColumnName="alu_cod"),
		@JoinColumn(name="preg_cod", referencedColumnName="preg_cod"),
		@JoinColumn(name="test_cod", referencedColumnName="test_cod")
		})
	private Respuesta respuesta;

	public Estado() {
	}

	public EstadoPK getId() {
		return this.id;
	}

	public void setId(EstadoPK id) {
		this.id = id;
	}

	public String getEstDes() {
		return this.estDes;
	}

	public void setEstDes(String estDes) {
		this.estDes = estDes;
	}

	public String getEstGrav() {
		return this.estGrav;
	}

	public void setEstGrav(String estGrav) {
		this.estGrav = estGrav;
	}

	public String getSetNom() {
		return this.setNom;
	}

	public void setSetNom(String setNom) {
		this.setNom = setNom;
	}

	public int getSetPsi() {
		return this.setPsi;
	}

	public void setSetPsi(int setPsi) {
		this.setPsi = setPsi;
	}

	public List<AlertaParque> getAlertaParques() {
		return this.alertaParques;
	}

	public void setAlertaParques(List<AlertaParque> alertaParques) {
		this.alertaParques = alertaParques;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public EstadoTipo getEstadoTipo() {
		return this.estadoTipo;
	}

	public void setEstadoTipo(EstadoTipo estadoTipo) {
		this.estadoTipo = estadoTipo;
	}

	public Respuesta getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

}