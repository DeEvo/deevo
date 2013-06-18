package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.user.client.ui.TextArea;

public class NuevoRolProfesorView extends ViewImpl implements
		NuevoRolProfesorPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoRolProfesorView> {
	}

	@UiField IntegerBox dniTexbox;
	@UiField TextBox nombresTexbox;
	@UiField TextBox apellidosTexbox;
	@UiField Button crearButton;
	@UiField TextBox contraTexbox;
	@UiField TextArea txtadescripcion;
	
	@Inject
	public NuevoRolProfesorView(final Binder binder) {
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

	@Override
	public Button getCrearButton() {
		// TODO Auto-generated method stub
		return crearButton;
	}

	public TextBox getContraTexbox() {
		return contraTexbox;
	}

	public TextArea getTxtadescripcion() {
		return txtadescripcion;
	}
	
	
	
}
