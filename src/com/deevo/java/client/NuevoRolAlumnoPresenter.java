package com.deevo.java.client;

import java.util.List;

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
import com.google.gwt.user.client.Window;
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
		public Button getCrearButton();
		public Button getCancelarButton() ;	
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
	//Listas
	private List<String> seccion_desc = null;
	private List<String> grado_descrip = null;
	private List<String> cod_aula = null; 
	private List<String> grado_descrip_filtro = null; 
	//Aula
	private String aula = null; 
	
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

		getView().getBuscarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				BuscarSourceEvent eventbuscar = new BuscarSourceEvent("nuevorolalumno");
				NuevoRolAlumnoPresenter.this.eventbus.fireEvent(eventbuscar);
				//buscarPopPresenter.getView().getEntidadTextbox().setText("Persona");
				addToPopupSlot(buscarPopPresenter);
			}
		});
		//Filtra el la seccion por cada grado
		getView().getGradoListbox().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int i=0;
				getView().getSeccionListbox().clear();
				while(i< grado_descrip.size()){
					if(grado_descrip.get(i).equals(getView().getGradoListbox().getValue(getView().getGradoListbox().getSelectedIndex()))){
						getView().getSeccionListbox().addItem(seccion_desc.get(i));
					}
					i++;
				}
			}
		});
		
		getView().getCrearButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int i =0;
				while(i< grado_descrip.size()){
					if(grado_descrip.get(i).equals(getView().getGradoListbox().getValue(getView().getGradoListbox().getSelectedIndex()))){
						if(seccion_desc.get(i).equals(getView().getSeccionListbox().getValue(getView().getSeccionListbox().getSelectedIndex()))){
							aula = cod_aula.get(i);
						}
					}	
					i++;
				}
			}
		});
	}
	
	@Inject DispatchAsync dispatchAsync;
	
	@Override
	protected void onReset() {
		super.onReset();
		getView().getDniTexbox().setText(dni);
		getView().getNombresTexbox().setText(nombres);
		getView().getApellidosTexbox().setText(apellidos);
		
		GetAula action= new GetAula("1");
		dispatchAsync.execute(action, getaulaCallback);	
	}
	
	protected void onHide(){
		super.onHide();
		getView().getDniTexbox().setText("");
		getView().getNombresTexbox().setText("");
		getView().getApellidosTexbox().setText("");
		getView().getGradoListbox().clear();
		getView().getSeccionListbox().clear();
	}
	
	private AsyncCallback<GetAulaResult> getaulaCallback = new AsyncCallback<GetAulaResult>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(GetAulaResult result) {
			int i;
			getView().getGradoListbox().clear();
			for(i=0;i< result.getGrado_descrip_filtro().size();i++){
				getView().getGradoListbox().addItem(result.getGrado_descrip_filtro().get(i));
			}
			seccion_desc = result.getSeccion_desc();
			grado_descrip = result.getGrado_descrip();
			cod_aula = result.getCod_aula();
			grado_descrip_filtro = result.getGrado_descrip_filtro();
		}
	};
}
