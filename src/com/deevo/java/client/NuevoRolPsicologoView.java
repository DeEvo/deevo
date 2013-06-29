package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NuevoRolPsicologoView extends ViewImpl implements
		NuevoRolPsicologoPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoRolPsicologoView> {
	}

	@UiField IntegerBox dniTexbox;
	@UiField TextBox nombresTexbox;
	@UiField TextBox apellidosTexbox;
	@UiField TextBox usuarioTexbox;
	@UiField TextArea descripcionTextarea;
	@UiField Button buscarButton;
	@UiField Button asignarButton;
	@UiField Button cancelarButton;
	@UiField CheckBox aulaCheckbox;
	@UiField ListBox gradoListbox;
	@UiField ListBox seccionListbox;
	
	
	@Inject
	public NuevoRolPsicologoView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	public IntegerBox getDniTexbox() {
		return dniTexbox;
	}

	public TextBox getNombresTexbox() {
		return nombresTexbox;
	}

	public TextBox getApellidosTexbox() {
		return apellidosTexbox;
	}

	public TextArea getDescripcionTextarea() {
		return descripcionTextarea;
	}

	public Button getBuscarButton() {
		return buscarButton;
	}

	public Button getAsignarButton() {
		return asignarButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public CheckBox getAulaCheckbox() {
		return aulaCheckbox;
	}

	public ListBox getGradoListbox() {
		return gradoListbox;
	}

	public ListBox getSeccionListbox() {
		return seccionListbox;
	}

	public Widget getWidget() {
		return widget;
	}

	public TextBox getUsuarioTexbox() {
		return usuarioTexbox;
	}
	
}
