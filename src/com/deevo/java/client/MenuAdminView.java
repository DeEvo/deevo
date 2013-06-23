package com.deevo.java.client;

import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class MenuAdminView extends ViewImpl implements
		MenuAdminPresenter.MyView {

	@UiField Label perfil;
	@UiField Label padreRol;
	@UiField Label profesorRol;
	@UiField Label psicologoRol;
	@UiField Label alumnoUsuario;
	@UiField Label padreUsuario;
	@UiField Label profesorUsuario;
	@UiField Label psicologoUsuario;
	@UiField Label alumnoRol;
	@UiField Label alumnoBuscar;
	@UiField Label grupoBuscar;
	@UiField Label aulaBuscar;
	@UiField Label aulaAcad;
	@UiField Label cursoAcad;
	@UiField Label asigcursoAcad;
	@UiField Label habcursoAcad;
	@UiField Label profesorAcad;
	@UiField Label newaulaAcad;
	@UiField Label newgradoAcad;
	@UiField Label newseccionAcad;
	@UiField Label newperiodoAcad;
	@UiField Label newcursoAcad;
	@UiField Label academicoEstado;
	@UiField Label fisicoEstado;
	@UiField Label psicomotrizEstado;
	@UiField Label aulaEstado;
	@UiField Label grupoEstado;
	@UiField Label estadisticas;
	@UiField Label inicialEvaluacion;
	@UiField Label bpreguntasEvaluacion;
	@UiField Label elabpruebaEvaluacion;
	@UiField Label srespuestasEvaluacion;
	@UiField Label nuevaAlerta;
	@UiField Label bandejaAlerta;
	
	public interface Binder extends UiBinder<Widget, MenuAdminView> {
	}

	private final Widget widget;

	@Inject
	public MenuAdminView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@Inject
	PlaceManager placeManager;
	
	//MENU PERFIL
	@UiHandler("perfil")
	void onPerfilClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.verperfil);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("alumnoUsuario")
	void onAlumnoUsuarioClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevousuario).with("valor", "alumno");				
		placeManager.revealPlace(request);
	}
	//FIN DE MENU PERFIL
	
	//MENU USUARIO
	//*submenu nuevos usuario
	@UiHandler("padreUsuario")
	void onPadreUsuarioClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevousuario).with("valor", "padre");			
		placeManager.revealPlace(request);
	}
	
	@UiHandler("profesorUsuario")
	void onProfesorUsuarioClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevousuario).with("valor", "profesor");				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("psicologoUsuario")
	void onPsicologoUsuarioClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevousuario).with("valor", "psicologo");			
		placeManager.revealPlace(request);
	}
	//*fin submenu nuevos usuarios
	
	//*submenu asignacion roles
	@UiHandler("alumnoRol")
	void onAlumnoRolClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevorolalumno);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("padreRol")
	void onPadreRolClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevorolpadre);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("profesorRol")
	void onProfesorRolClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevorolprofesor);		
		placeManager.revealPlace(request);
	}
	
	@UiHandler("psicologoRol")
	void onPsicologoRolClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevorolpsicologo);				
		placeManager.revealPlace(request);
	}
	//*fin submenu asignacion roles
	//FIN MENU USUARIOS
	
	//MENU BUSCAR
	@UiHandler("alumnoBuscar")
	void onAlumnoBuscarClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.busquedaalumno);				
		placeManager.revealPlace(request);
	}

	@UiHandler("grupoBuscar")
	void onGrupoBuscarClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.busquedagrupo);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("aulaBuscar")
	void onAulaBuscarClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.busquedaporaula);				
		placeManager.revealPlace(request);
	}
	//FIN MENU BUSCAR
	
	//MENU ACADEMICO
	@UiHandler("aulaAcad")
	void onAulaAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.veraula);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("cursoAcad")
	void onCursoAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.vercurso);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("asigcursoAcad")
	void onAsigcursoAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.cursoprofesor);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("habcursoAcad")
	void onHabcursoAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.habilitarcurso);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("profesorAcad")
	void onProfesorAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.verprofesor);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("newaulaAcad")
	void onNewaulaAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevaaula);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("newgradoAcad")
	void onNewgradoAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevogrado);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("newseccionAcad")
	void onNewseccionAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevaseccion);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("newperiodoAcad")
	void onNewperiodoAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevoperiodo);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("newcursoAcad")
	void onNewcursoAcadClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevocurso);				
		placeManager.revealPlace(request);
	}
	//FIN MENU ACADEMICO
	
	//MENU DEEVO
	//*submenu Estado
	@UiHandler("academicoEstado")
	void onAcademicoEstadoClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.estadoacademico);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("fisicoEstado")
	void onFisicoEstadoClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.estadofisico);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("psicomotrizEstado")
	void onPsicomotrizEstadoClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.estadopsicomotriz);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("aulaEstado")
	void onAulaEstadoClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.estadoaula);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("grupoEstado")
	void onGrupoEstadoClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.estadogrupo);				
		placeManager.revealPlace(request);
	}
	//*finsubmenu Estado
	
	//*submenu Estadistica
	@UiHandler("estadisticas")
	void onEstadisticasClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.estadisticas);				
		placeManager.revealPlace(request);
	}
	//*fin submenu Estadistica
	
	//*submenu Evaluacion
	@UiHandler("inicialEvaluacion")
	void onInicialEvaluacionClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.evaluacioninicial);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("bpreguntasEvaluacion")
	void onBpreguntasEvaluacionClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.bancopreguntas);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("elabpruebaEvaluacion")
	void onElabpruebaEvaluacionClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.elabpruebas);				
		placeManager.revealPlace(request);
	}
	@UiHandler("srespuestasEvaluacion")
	void onSrespuestasEvaluacionClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.uploadrespuestas);				
		placeManager.revealPlace(request);
	}
	//*fin submenu Evaluacion
	
	//*submenu Alertas
	@UiHandler("nuevaAlerta")
	void onNuevaAlertaClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevaalerta);				
		placeManager.revealPlace(request);
	}
	@UiHandler("bandejaAlerta")
	void onBandejaAlertaClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.bandejaalerta);				
		placeManager.revealPlace(request);
	}
	//*fin submenu Alertas
	//FIN MENU DEEVO
}
