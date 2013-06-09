package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class EstadisticasView extends ViewImpl implements
		EstadisticasPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, EstadisticasView> {
	}

	@Inject
	public EstadisticasView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
