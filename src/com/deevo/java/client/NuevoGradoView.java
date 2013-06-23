package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NuevoGradoView extends ViewImpl implements
		NuevoGradoPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoGradoView> {
	}

	@Inject
	public NuevoGradoView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
