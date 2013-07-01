package com.deevo.java.client;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.action.NuevoPadre;
import com.deevo.java.client.action.NuevoPadreResult;
import com.deevo.java.client.action.NuevoProfesor;
import com.deevo.java.client.action.NuevoProfesorResult;
import com.deevo.java.client.event.BuscarSourceEvent;
import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public class NuevoRolPadrePresenter	extends
		Presenter<NuevoRolPadrePresenter.MyView, NuevoRolPadrePresenter.MyProxy> {

	public interface MyView extends View {
		public TextBox getDniTexbox();
		public TextBox getNombresTexbox();
		public TextBox getApellidosTexbox();
		public Button getBuscarButton();
		public Button getCrearButton();
		public Button getCrearehijoButton();
		public Button getCancelarButoon();
		public TextBox getUsuarioTexbox();
		public Button getCancelarButton();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.nuevorolpadre)
	public interface MyProxy extends ProxyPlace<NuevoRolPadrePresenter> {
	}
	@Inject BuscarPersonaPopupPresenter buscarpersonaPopPresenter;
	private EventBus eventbus;
	@Inject
	public NuevoRolPadrePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
		super(eventBus, view, proxy);
		this.eventbus = eventBus;
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutMainPresenter.SLOT_SetMainContent, this);
	}

	private String dni ="";
	private String nombres ="";
	private String apellidos ="";
	private String cod_user ="";
	private Boolean padre_bio;
	
	@Inject DispatchAsync dispatchAsync;
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		dni= request.getParameter("dni", "");
		nombres= request.getParameter("nombres", "");
		apellidos= request.getParameter("apaterno", "") +" "+ request.getParameter("amaterno", "");
		cod_user = request.getParameter("cod_user", "");
	}
		
	@Override
	protected void onBind() {
		super.onBind();
		
		getView().getBuscarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				BuscarSourceEvent eventbuscar = new BuscarSourceEvent("nuevorolpadre");
				NuevoRolPadrePresenter.this.eventbus.fireEvent(eventbuscar);
				addToPopupSlot(buscarpersonaPopPresenter);
			}
		});
		
		getView().getCrearButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				NuevoPadre nuevopadre = new NuevoPadre(
						getView().getDniTexbox().getText(),
						"", padre_bio);
				dispatchAsync.execute(nuevopadre, getnuevopadreAsyncCallback);
			}
		});
		// crear y asiganar hijos
		getView().getCrearehijoButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
			}
		});

	}
	
	@Override
	protected void onReset() {
		super.onReset();
		getView().getDniTexbox().setText(dni);
		getView().getNombresTexbox().setText(nombres);
		getView().getApellidosTexbox().setText(apellidos);	
		getView().getUsuarioTexbox().setText(cod_user);
		
	}

	protected void onHide(){
		super.onHide();
		getView().getDniTexbox().setText("");
		getView().getNombresTexbox().setText("");
		getView().getApellidosTexbox().setText("");
		getView().getUsuarioTexbox().setText("");
	}
	
	private AsyncCallback<NuevoPadreResult> getnuevopadreAsyncCallback = new AsyncCallback<NuevoPadreResult>() {

		@Override
		public void onFailure(Throwable caught) {
			
		}

		@Override
		public void onSuccess(NuevoPadreResult result) {
			Window.alert(result.getMensaje());
			
		}
	};
}
