package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.CellTable;

public class BusquedaAvanzadaView extends ViewImpl implements
		BusquedaAvanzadaPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, BusquedaAvanzadaView> {
	}

	@Inject
	public BusquedaAvanzadaView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	@UiField(provided=true) CellTable<Object> cellTable = new CellTable<Object>();
}
