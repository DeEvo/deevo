package com.deevo.java.client;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;

public class BuscarPopupPresenter extends
		PresenterWidget<BuscarPopupPresenter.MyView> {

	public interface MyView extends PopupView {
		// TODO Put your view methods here
	}

	@Inject
	public BuscarPopupPresenter(final EventBus eventBus, final MyView view) {
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
