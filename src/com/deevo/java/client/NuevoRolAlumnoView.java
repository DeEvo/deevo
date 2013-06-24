package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NuevoRolAlumnoView extends ViewImpl implements
		NuevoRolAlumnoPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoRolAlumnoView> {
	}

	@UiField IntegerBox dniTexbox;
	@UiField TextBox nombresTexbox;
	@UiField TextBox apellidosTexbox;
	@UiField Button buscarButton;
	@UiField TextBox MinediTextBox;
	@UiField ListBox seccionListbox;
	@UiField ListBox gradoListbox;
	@Inject
	public NuevoRolAlumnoView(final Binder binder) {
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

	public Button getBuscarButton() {
		return buscarButton;
	}

	public TextBox getMinediTextBox() {
		return MinediTextBox;
	}

	public ListBox getSeccionListbox() {
		return seccionListbox;
	}

	public ListBox getGradoListbox() {
		return gradoListbox;
	}
}
