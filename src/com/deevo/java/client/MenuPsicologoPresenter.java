package com.deevo.java.client;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;

public class MenuPsicologoPresenter extends
		PresenterWidget<MenuPsicologoPresenter.MyView> {

	public interface MyView extends View {
	}

	@Inject
	public MenuPsicologoPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
}
