package com.deevo.java.client;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.action.GetAula;
import com.deevo.java.client.action.GetAulaResult;
import com.deevo.java.client.action.GetPersona;
import com.deevo.java.client.action.GetPersonaResult;
import com.deevo.java.client.event.BuscarSourceEvent;
import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class NuevoRolAlumnoPresenter extends
		Presenter<NuevoRolAlumnoPresenter.MyView, NuevoRolAlumnoPresenter.MyProxy> {

	public interface MyView extends View {
		public IntegerBox getDniTexbox();
		public TextBox getNombresTexbox();
		public TextBox getApellidosTexbox();
		public Button getBuscarButton();
		public TextBox getMinediTextBox();
		public ListBox getSeccionListbox();
		public ListBox getGradoListbox();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.nuevorolalumno)
	public interface MyProxy extends ProxyPlace<NuevoRolAlumnoPresenter> {
	}

	private EventBus eventbus;
	
	@Inject
	public NuevoRolAlumnoPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
		super(eventBus, view, proxy);
		this.eventbus = eventBus;
	}

	@Inject BuscarPopupPresenter buscarPopPresenter;
	
	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutMainPresenter.SLOT_SetMainContent, this);
	}

	private String dni ="";
	private String nombres ="";
	private String apellidos ="";
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		dni= request.getParameter("dni", "");
		nombres= request.getParameter("nombres", "");
		apellidos= request.getParameter("apaterno", "") +" "+ request.getParameter("amaterno", "");
	}
	
	@Override
	protected void onBind() {
		super.onBind();
	}
	
	@Inject DispatchAsync dispatchAsync;
	
	@Override
	protected void onReset() {
		super.onReset();
		getView().getDniTexbox().setText(dni);
		getView().getNombresTexbox().setText(nombres);
		getView().getApellidosTexbox().setText(apellidos);
		
		//llemnado lso combobox
		GetAula action= new GetAula("1");
		dispatchAsync.execute(action, getaulaCallback);

		
		getView().getBuscarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				BuscarSourceEvent eventbuscar = new BuscarSourceEvent("nuevorolalumno");
				NuevoRolAlumnoPresenter.this.eventbus.fireEvent(eventbuscar);
				//buscarPopPresenter.getView().getEntidadTextbox().setText("Persona");
				addToPopupSlot(buscarPopPresenter);
			}
		});
		
		
		
	}
	
	private AsyncCallback<GetAulaResult> getaulaCallback = new AsyncCallback<GetAulaResult>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(GetAulaResult result) {
			int i =0;
			while(i< result.getCod_aula().size()){
				getView().getGradoListbox().addItem(result.getGrado_descrip().get(i));
				getView().getSeccionListbox().addItem(result.getSeccion_desc().get(i));
				i++;
			}
			
		}
	
	
	
	};
}
