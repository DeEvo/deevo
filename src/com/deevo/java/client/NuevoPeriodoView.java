package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NuevoPeriodoView extends ViewImpl implements
		NuevoPeriodoPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoPeriodoView> {
	}

	@Inject
	public NuevoPeriodoView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
