package com.deevo.java.client;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class BuscarPopupPresenter extends
		PresenterWidget<BuscarPopupPresenter.MyView> {

	public interface MyView extends PopupView {
		// TODO Put your view methods here
		public Button getLimpiarButton();
		public Button getBuscarButton();
		public Button getCancelarButton();
		public ListBox getCampoListbox();
		public TextBox getBuscarTextbox();
		public TextBox getEntidadTextbox();
	}

	@Inject
	public BuscarPopupPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();

		getView().getCancelarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				getView().getBuscarTextbox().setText("");
				getView().hide();
			}
		});
		
		getView().getLimpiarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getView().getBuscarTextbox().setText("");
				
			}
		});
	}

	@Override
	protected void onReset() {
		super.onReset();

	}
}
