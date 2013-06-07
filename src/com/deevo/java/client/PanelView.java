package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class PanelView extends ViewImpl implements PanelPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, PanelView> {
	}

	@UiField Button homeButton;
	
	@Inject
	public PanelView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	public Button getHomeButton() {
		return homeButton;
	}
	
}
