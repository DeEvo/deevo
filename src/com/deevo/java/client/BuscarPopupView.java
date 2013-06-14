package com.deevo.java.client;

import com.gwtplatform.mvp.client.PopupViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;

public class BuscarPopupView extends PopupViewImpl implements
		BuscarPopupPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, BuscarPopupView> {
	}

	@Inject
	public BuscarPopupView(final EventBus eventBus, final Binder binder) {
		super(eventBus);
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
