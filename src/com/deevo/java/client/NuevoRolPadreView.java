package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NuevoRolPadreView extends ViewImpl implements
		NuevoRolPadrePresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoRolPadreView> {
	}

	@UiField TextBox dniTexbox;
	@UiField TextBox nombresTexbox;
	@UiField TextBox apellidosTexbox;
	@UiField TextBox usuarioTexbox;
	@UiField Button buscarButton;
	@UiField Button crearButton;
	@UiField Button crearehijoButton;
	@UiField Button cancelarButton;

	@Inject
	public NuevoRolPadreView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	public TextBox getDniTexbox() {
		return dniTexbox;
	}

	public TextBox getNombresTexbox() {
		return nombresTexbox;
	}

	public TextBox getApellidosTexbox() {
		return apellidosTexbox;
	}

	public Widget getWidget() {
		return widget;
	}

	public Button getBuscarButton() {
		return buscarButton;
	}

	public Button getCrearButton() {
		return crearButton;
	}

	public Button getCrearehijoButton() {
		return crearehijoButton;
	}

	public Button getCancelarButoon() {
		return cancelarButton;
	}

	public TextBox getUsuarioTexbox() {
		return usuarioTexbox;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}	
}
