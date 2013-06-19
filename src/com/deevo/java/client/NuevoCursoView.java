package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NuevoCursoView extends ViewImpl implements
		NuevoCursoPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoCursoView> {
	}

	@Inject
	public NuevoCursoView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
