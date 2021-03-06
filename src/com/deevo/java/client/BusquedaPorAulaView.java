package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;

public class BusquedaPorAulaView extends ViewImpl implements
		BusquedaPorAulaPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, BusquedaPorAulaView> {
	}

	@Inject
	public BusquedaPorAulaView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
