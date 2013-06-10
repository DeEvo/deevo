package com.deevo.java.client;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.action.NuevaPersona;
import com.deevo.java.client.action.NuevaPersonaResult;
import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import java.util.Date;

public class NuevaPersonaPresenter extends
		Presenter<NuevaPersonaPresenter.MyView, NuevaPersonaPresenter.MyProxy> {

	public interface MyView extends View {
		public Button getIngresarButton();
		public IntegerBox getDniTexbox();
		public TextBox getNombresTexbox();
		public TextBox getAppaternTexbox();
		public TextBox getApmaternTexbox();
		public TextBox getEstcivTexbox();
		public DateBox getFnacTexbox();
		public IntegerBox getTelfTexbox();
		public IntegerBox getCelTexbox();
		public TextBox getDirTexbox();
		public IntegerBox getEmailTexbox();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.nuevapesona)
	public interface MyProxy extends ProxyPlace<NuevaPersonaPresenter> {
	}

	@Inject
	public NuevaPersonaPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutMainPresenter.SLOT_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Inject DispatchAsync dispatchAsync;
	
	@Override
	protected void onReset() {
		super.onReset();
		
		getView().getIngresarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Date fecha = getView().getFnacTexbox().getValue();
				Window.alert(String.valueOf(fecha));
				NuevaPersona action = new NuevaPersona(
						Integer.parseInt(getView().getDniTexbox().getText()), 
						getView().getNombresTexbox().getText(),
						getView().getAppaternTexbox().getText(),
						getView().getApmaternTexbox().getText(),
						null,
						Integer.parseInt(getView().getTelfTexbox().getText()),
						Integer.parseInt(getView().getCelTexbox().getText()),
						getView().getDirTexbox().getText(),
						getView().getEmailTexbox().getText(),
						getView().getEstcivTexbox().getText());
				dispatchAsync.execute(action, nuevapersonaCallback);
			}
		});
		
	}
		
	private AsyncCallback<NuevaPersonaResult> nuevapersonaCallback = new AsyncCallback<NuevaPersonaResult>() {
		
		@Override
		public void onSuccess(NuevaPersonaResult result) {
			// TODO Auto-generated method stub
			Window.alert("Se ha ingresado correctamente");
		
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Error Fatal");
			
		}
	};
	
}
