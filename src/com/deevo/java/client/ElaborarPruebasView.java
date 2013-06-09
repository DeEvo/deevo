package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ElaborarPruebasView extends ViewImpl implements
		ElaborarPruebasPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, ElaborarPruebasView> {
	}

	@Inject
	public ElaborarPruebasView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
