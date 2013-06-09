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

public class MenuPsicologoView extends ViewImpl implements
		MenuPsicologoPresenter.MyView {

	private final Widget widget;

	@UiField Label nuevoAlumno;
	
	public interface Binder extends UiBinder<Widget, MenuPsicologoView> {
	}

	@Inject
	public MenuPsicologoView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Inject
	PlaceManager placeManager;
	
	@UiHandler("nuevoAlumno")
	void onLabelClick(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(NameTokens.nuevoalumno);				
		placeManager.revealPlace(request);
	}
}
