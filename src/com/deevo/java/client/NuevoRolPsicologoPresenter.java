package com.deevo.java.client;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.action.NuevaPersonaResult;
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
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.deevo.java.client.action.GetAula;
import com.deevo.java.client.action.GetAulaResult;
import com.deevo.java.client.action.NuevaPersona;
import com.deevo.java.client.action.NuevoPsicologo;
import com.deevo.java.client.action.NuevoPsicologoResult;

public class NuevoRolPsicologoPresenter extends
		Presenter<NuevoRolPsicologoPresenter.MyView, NuevoRolPsicologoPresenter.MyProxy> {

	public interface MyView extends View {
		public IntegerBox getDniTexbox();
		public TextBox getNombresTexbox();
		public TextBox getApellidosTexbox();
		public CheckBox getAulaCheckbox();
		public TextArea getDescripcionTextarea();
		public Button getBuscarButton();
		public Button getAsignarButton();
		public Button getCancelarButton();
		public ListBox getGradoListbox();
		public ListBox getSeccionListbox();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.nuevorolpsicologo)
	public interface MyProxy extends ProxyPlace<NuevoRolPsicologoPresenter> {
	}

	@Inject DispatchAsync dispatchAsync;
	
	@Inject BuscarPopupPresenter buscarPopPresenter;
	private EventBus eventbus;
	@Inject
	public NuevoRolPsicologoPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
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
	//lsitas necesarias
	private List<String> seccion_desc = new ArrayList<String>();
	private List<String> grado_descrip = new ArrayList<String>();
	private List<String> cod_aula = new ArrayList<String>();
	private List<String> grado_descrip_filtro = new ArrayList<String>(); 
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
				BuscarSourceEvent eventbuscar = new BuscarSourceEvent("nuevorolpsicologo");
				NuevoRolPsicologoPresenter.this.eventbus.fireEvent(eventbuscar);
				//buscarPopPresenter.getView().getEntidadTextbox().setText("Persona");
				addToPopupSlot(buscarPopPresenter);
			}
		});
		
		getView().getAsignarButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String des = null;
				des = "";
				if(!getView().getDescripcionTextarea().getText().isEmpty()){
					des = getView().getDescripcionTextarea().getText();
				}
				//obtener el aula
				int i =0;
				while(i< grado_descrip.size()){
					if(grado_descrip.get(i).equals(getView().getGradoListbox().getValue(getView().getGradoListbox().getSelectedIndex()))){
						if(seccion_desc.get(i).equals(getView().getSeccionListbox().getValue(getView().getSeccionListbox().getSelectedIndex()))){
							aula = cod_aula.get(i);
						}
					}	
					i++;
				}
				//ver si se asigna aula
				Boolean f = false;
				if(getView().getAulaCheckbox().isAttached()) f= true;
				
				//ejecucion con la bs
				NuevoPsicologo action = new NuevoPsicologo( 
						des,
						getView().getDniTexbox().getText(),
						"ivcuervogu",
						"1",
						aula,
						f);
				dispatchAsync.execute(action, nuevopsicologoCallback);
			}
		});
		

		//filtrando secciones por grado
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
	}
	
	@Override
	protected void onReset() {
		super.onReset();
		getView().getDniTexbox().setText(dni);
		getView().getNombresTexbox().setText(nombres);
		getView().getApellidosTexbox().setText(apellidos);	
		//llemnado lso combobox
		GetAula action= new GetAula("1");
		dispatchAsync.execute(action, getaulaCallback);
				
	}
	
	protected void onHide(){
		super.onHide();
		getView().getDniTexbox().setText("");
		getView().getNombresTexbox().setText("");
		getView().getApellidosTexbox().setText("");	
		getView().getAulaCheckbox().setValue(false);
		getView().getDescripcionTextarea().setText("");
		getView().getGradoListbox().clear();
		getView().getSeccionListbox().clear();
		
	}
	
	private AsyncCallback<NuevoPsicologoResult> nuevopsicologoCallback = new AsyncCallback<NuevoPsicologoResult>(){

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("falla");
		}

		@Override
		public void onSuccess(NuevoPsicologoResult result) {
			Window.alert(result.getMensaje());
		}
		
	};
	
	private AsyncCallback<GetAulaResult> getaulaCallback = new AsyncCallback<GetAulaResult>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onSuccess(GetAulaResult result) {
			getView().getGradoListbox().clear();
			int i;
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
