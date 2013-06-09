package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class EAcademicoView extends ViewImpl implements
		EAcademicoPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, EAcademicoView> {
	}

	@Inject
	public EAcademicoView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
