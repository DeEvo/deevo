package com.deevo.java.client;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.action.NuevaPersona;
import com.deevo.java.client.action.NuevaPersonaResult;
import com.deevo.java.client.event.MostrarPopupEvent;
import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class NuevoUsuarioPresenter extends
		Presenter<NuevoUsuarioPresenter.MyView, NuevoUsuarioPresenter.MyProxy> {

	public interface MyView extends View {
		public Button getIngresarButton();
		public IntegerBox getDniTexbox();
		public TextBox getNombresTexbox();
		public TextBox getAppaternTexbox();
		public TextBox getApmaternTexbox();
		public ListBox getEstcivListbox();
		public ListBox getSexoListbox(); 
		public DateBox getFnacTexbox();
		public IntegerBox getTelfTexbox();
		public IntegerBox getCelTexbox();
		public TextBox getDirTexbox();
		public TextBox getEmailTexbox();
		public ListBox getRolListbox();
		
	}
	
	@ProxyCodeSplit
	@NameToken(NameTokens.nuevousuario)
	public interface MyProxy extends ProxyPlace<NuevoUsuarioPresenter> {
	}
	
	public Boolean direccion = null;
	public String valor = null;
	
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		valor= request.getParameter("valor", "padre");
		if(valor == "alumno"){
			direccion = false;	
		} 
		if(valor == "padre"){
			direccion = true;	
		} 
		if(valor == "psicologo"){
			direccion = true;	
		} 
		if(valor == "profesor"){
			direccion = true;
		} 
	}
	
	private EventBus eventbus;
		
	@Inject
	public NuevoUsuarioPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
		this.eventbus = eventBus;
	}
	
	@Inject NuevoUsuarioPopupPresenter nuevoUsuarioPopPresenter;
	@Inject	PlaceManager placeManager;

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutMainPresenter.SLOT_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
			getView().getIngresarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				//HASTA ACA, DEBERIA IR EN EL ACTION ONSUCCESS
				
				NuevaPersona action = new NuevaPersona(
					getView().getDniTexbox().getText(), 
					getView().getNombresTexbox().getText(),
					getView().getAppaternTexbox().getText(),
					getView().getApmaternTexbox().getText(),
					getView().getFnacTexbox().getValue(),
					getView().getTelfTexbox().getValue(),
					getView().getCelTexbox().getValue(),
					getView().getDirTexbox().getText(),
					getView().getEmailTexbox().getText(),
					getView().getEstcivListbox().getItemText(getView().getEstcivListbox().getSelectedIndex()),
					direccion,
					getView().getSexoListbox().getItemText(getView().getSexoListbox().getSelectedIndex()));
					if(valida()){
						dispatchAsync.execute(action, nuevapersonaCallback);
					}
				}
		});
		
	}

	@Inject DispatchAsync dispatchAsync;
	
	@Override
	protected void onReset() {
		super.onReset();
		
	}
		
	private AsyncCallback<NuevaPersonaResult> nuevapersonaCallback = new AsyncCallback<NuevaPersonaResult>() {
		
		@Override
		public void onSuccess(NuevaPersonaResult result) {
			// TODO Auto-generated method stub
			if(direccion){
			nuevoUsuarioPopPresenter.getView().getUsuario().setText(result.getUsurCod());
			nuevoUsuarioPopPresenter.getView().getContrasennia().setText(result.getPerPass());
			MostrarPopupEvent event = new MostrarPopupEvent(valor,
					getView().getDniTexbox().getText(), 
					getView().getNombresTexbox().getText(),
					getView().getAppaternTexbox().getText(),
					getView().getApmaternTexbox().getText());
			NuevoUsuarioPresenter.this.eventbus.fireEvent(event);
			addToPopupSlot(nuevoUsuarioPopPresenter);
			}else{
				Window.alert("Exitos pero no tienes usuario =(!");
			}	
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Error: "+ caught.getMessage());
		}
	};
	
	

	public boolean valida(){
		
		
		if(getView().getDniTexbox().getText().length() != 8){
			Window.alert("El DNI debe tener 8 digitos");
			getView().getDniTexbox().setFocus(true);
			return false;
		}
		
		if(getView().getDniTexbox().getText().isEmpty()){
			Window.alert("Debe completar el DNI");
			getView().getDniTexbox().setFocus(true);
			return false;
		}
		
		if(getView().getNombresTexbox().getText().isEmpty()){
			Window.alert("Debe completar el Nombre");
			getView().getNombresTexbox().setFocus(true);
			return false;
		}
		
		if(getView().getAppaternTexbox().getText().isEmpty()){
			Window.alert("Debe completar el Apellido paterno");
			getView().getAppaternTexbox().setFocus(true);
			return false;
		}
		
		if(getView().getAppaternTexbox().getText().isEmpty()){
			Window.alert("Debe completar el Apellido materno");
			getView().getAppaternTexbox().setFocus(true);
			return false;
		}
		
		if(getView().getFnacTexbox().getValue() == null){
			Window.alert("Debe completar la fecha de nacimiento");
			getView().getFnacTexbox().setFocus(true);
			return false;
		}
		
		return true;
	}
	
	
}
