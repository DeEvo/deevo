package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IntegerBox;
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

}
