package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NuevoRolPadreView extends ViewImpl implements
		NuevoRolPadrePresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoRolPadreView> {
	}

	@UiField IntegerBox dniTexbox;
	@UiField TextBox nombresTexbox;
	@UiField TextBox apellidosTexbox;
	
	@Inject
	public NuevoRolPadreView(final Binder binder) {
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
