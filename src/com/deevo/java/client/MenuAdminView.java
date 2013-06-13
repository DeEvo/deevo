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
	@UiField Label alumnoRol;
	@UiField Label padreRol;
	@UiField Label profesorRol;
	@UiField Label psicologoRol;
	@UiField Label nuevoUsuario;
	
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
	
	@UiHandler("perfil")
	void onPerfilClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.perfil);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("nuevoUsuario")
	void onNuevoUsuarioClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevousuario);				
		placeManager.revealPlace(request);
	}
	
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

}
