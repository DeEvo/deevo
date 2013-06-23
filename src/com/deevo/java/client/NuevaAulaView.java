package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;

public class NuevaAulaView extends ViewImpl implements
		NuevaAulaPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevaAulaView> {
	}

	@Inject
	public NuevaAulaView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	@UiField(provided=true) CellTable<Object> cellproTable = new CellTable<Object>();
	@UiField(provided=true) CellTable<Object> cellpsiTable = new CellTable<Object>();
}
