package com.deevo.java.client;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.action.NuevoPadre;
import com.deevo.java.client.action.NuevoPadreResult;
<<<<<<< master
=======
import com.deevo.java.client.action.NuevoProfesor;
import com.deevo.java.client.action.NuevoProfesorResult;
>>>>>>> f3fb4ab ya esta arreglado el Git Local Ivan
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
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;

public class NuevoRolPadrePresenter	extends
		Presenter<NuevoRolPadrePresenter.MyView, NuevoRolPadrePresenter.MyProxy> {

	public interface MyView extends View {
		public TextBox getDniTexbox();
		public TextBox getNombresTexbox();
		public TextBox getApellidosTexbox();
		public Button getBuscarButton();
		public Button getCrearButton();
<<<<<<< master
		public Button getCrearehijoButton();
		public Button getCancelarButoon();
=======
		public Button getCrearasinarButton();
		public Button getCancelarButton();
>>>>>>> f3fb4ab ya esta arreglado el Git Local Ivan
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.nuevorolpadre)
	public interface MyProxy extends ProxyPlace<NuevoRolPadrePresenter> {
	}
<<<<<<< master
	
=======

>>>>>>> f3fb4ab ya esta arreglado el Git Local Ivan
	@Inject BuscarPopupPresenter buscarPopPresenter;
	private EventBus eventbus;
	@Inject
	public NuevoRolPadrePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
		super(eventBus, view, proxy);
<<<<<<< master
		this.eventbus=  eventBus;
=======
		this.eventbus = eventBus;
>>>>>>> f3fb4ab ya esta arreglado el Git Local Ivan
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutMainPresenter.SLOT_SetMainContent, this);
	}

	private String dni ="";
	private String nombres ="";
	private String apellidos ="";
<<<<<<< master
	private Boolean padre_bio;
=======
	
	@Inject DispatchAsync dispatchAsync;
>>>>>>> f3fb4ab ya esta arreglado el Git Local Ivan
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		dni= request.getParameter("dni", "");
		nombres= request.getParameter("nombres", "");
		apellidos= request.getParameter("apaterno", "") +" "+ request.getParameter("amaterno", "");
	}
	
	@Inject DispatchAsync async;
	
	@Override
	protected void onBind() {
		super.onBind();
		
		getView().getBuscarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				BuscarSourceEvent eventbuscar = new BuscarSourceEvent("nuevorolpadre");
				NuevoRolPadrePresenter.this.eventbus.fireEvent(eventbuscar);
				addToPopupSlot(buscarPopPresenter);
			}
		});
		
		getView().getCrearButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				NuevoPadre nuevopadre = new NuevoPadre(
						getView().getDniTexbox().getText(),
						"");
				dispatchAsync.execute(nuevopadre, getnuevopadreAsyncCallback);
			}
		});
	}
	
	@Override
	protected void onReset() {
		super.onReset();
		getView().getDniTexbox().setText(dni);
		getView().getNombresTexbox().setText(nombres);
		getView().getApellidosTexbox().setText(apellidos);	
		
		getView().getBuscarButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				BuscarSourceEvent eventbuscar = new BuscarSourceEvent("nuevorolpadre");
				NuevoRolPadrePresenter.this.eventbus.fireEvent(eventbuscar);
				addToPopupSlot(buscarPopPresenter);	
			}
		});
		
		getView().getCrearButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				padre_bio = true;
				NuevoPadre nuevopadre = new NuevoPadre(
						getView().getDniTexbox().getText(),
						"",
						padre_bio);
				async.execute(nuevopadre, getAsyncCallback);
			}
		});
	}
	
<<<<<<< master
	private AsyncCallback<NuevoPadreResult> getAsyncCallback = new AsyncCallback<NuevoPadreResult>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(NuevoPadreResult result) {
			Window.alert(result.getMensaje());
		}
		
		
=======
	protected void onHide(){
		super.onHide();
		getView().getDniTexbox().setText("");
		getView().getNombresTexbox().setText("");
		getView().getApellidosTexbox().setText("");
	}
	
	private AsyncCallback<NuevoPadreResult> getnuevopadreAsyncCallback = new AsyncCallback<NuevoPadreResult>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(NuevoPadreResult result) {
			Window.alert(result.getMensaje());
			
		}
>>>>>>> f3fb4ab ya esta arreglado el Git Local Ivan
	};
}
