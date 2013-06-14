package com.deevo.java.client;

import com.gwtplatform.mvp.client.PopupViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class BuscarPopupView extends PopupViewImpl implements
		BuscarPopupPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, BuscarPopupView> {
	}

	@Inject
	public BuscarPopupView(final EventBus eventBus, final Binder binder) {
		super(eventBus);
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@UiField Button limpiarButton;
	@UiField Button buscarButton;
	@UiField Button cancelarButton;
	@UiField ListBox campoListbox;
	@UiField TextBox buscarTextbox;
	@UiField TextBox entidadTextbox;
	
	public Button getLimpiarButton() {
		return limpiarButton;
	}

	public Button getBuscarButton() {
		return buscarButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public ListBox getCampoListbox() {
		return campoListbox;
	}

	public TextBox getBuscarTextbox() {
		return buscarTextbox;
	}
	
	public TextBox getEntidadTextbox() {
		return entidadTextbox;
	}
	
}
