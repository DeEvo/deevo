package com.deevo.java.client;

import com.gwtplatform.mvp.client.PopupViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;

public class NuevoUsuarioPopupView extends PopupViewImpl implements
		NuevoUsuarioPopupPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoUsuarioPopupView> {
	}

	@Inject
	public NuevoUsuarioPopupView(final EventBus eventBus, final Binder binder) {
		super(eventBus);
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	@UiField Label mensaje;
	@UiField Label usuario;
	@UiField Label contrasennia;

	public Label getMensaje() {
		return mensaje;
	}

	public Label getUsuario() {
		return usuario;
	}

	public Label getContrasennia() {
		return contrasennia;
	}
	
}
