package com.deevo.java.client;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Label;

public class NuevoUsuarioPopupPresenter extends
		PresenterWidget<NuevoUsuarioPopupPresenter.MyView> {

	public interface MyView extends PopupView {
		// TODO Put your view methods here
		public Label getMensaje() ;
		public Label getUsuario(); 
		public Label getContrasennia();
	}

	@Inject
	public NuevoUsuarioPopupPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	protected void onReset() {
		super.onReset();
	}
}
