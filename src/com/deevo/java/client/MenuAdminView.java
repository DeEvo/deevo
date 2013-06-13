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
import com.google.gwt.user.client.ui.RadioButton;

public class MenuAdminView extends ViewImpl implements
		MenuAdminPresenter.MyView {

	@UiField Label perfil;
	@UiField RadioButton alumnoOption;
	@UiField RadioButton padreOption;
	@UiField RadioButton profesorOption;
	@UiField RadioButton psicologoOption;
	
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

	@UiHandler("alumnoOption")
	void onAlumnoOptionClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevousuario);				
		placeManager.revealPlace(request);
	}

	@UiHandler("padreOption")
	void onPadreOptionClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevousuario);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("profesorOption")
	void onProfesorOptionClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevousuario);				
		placeManager.revealPlace(request);
	}
	
	@UiHandler("psicologoOption")
	void onPsicologoOptionClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevousuario);				
		placeManager.revealPlace(request);
	}
}
