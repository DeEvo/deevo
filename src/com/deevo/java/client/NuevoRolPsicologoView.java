package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IntegerBox;
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
	
}
