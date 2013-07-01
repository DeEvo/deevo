package com.deevo.java.client;

import java.util.ArrayList;
import java.util.List;


//import com.deevo.java.client.BuscarPopupView.P;
import com.deevo.java.client.action.GetPersona;
import com.deevo.java.client.action.GetPersonaResult;
import com.deevo.java.client.event.BuscarSourceEvent;
import com.deevo.java.client.event.BuscarSourceEvent.BuscarSourceHandler;
import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;



public class BuscarPersonaPopupPresenter extends
		PresenterWidget<BuscarPersonaPopupPresenter.MyView> {

	public interface MyView extends PopupView {
		public Button getLimpiarButton();
		public Button getBuscarButton();
		public Button getIngresarButton();
		public Button getCancelarButton();
		public CellTable<P> getCellTable();
		public TextBox getDniTextbox() ;
		public TextBox getPaterTextbox();
		public TextBox getMaterTexbox() ;
		public TextBox getNombreTextbox();
	}
	
	private String dni;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String cod_user;
    private ListDataProvider<P> dataProvider = new ListDataProvider<P>();
	
	private SingleSelectionModel<P> selection = new SingleSelectionModel<P>();
	
         
	@Inject
	public BuscarPersonaPopupPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}
	
	@Inject
	PlaceManager placeManager;
	
	public static String origen = null;
	
	private BuscarSourceHandler buscarSourceHandler = new BuscarSourceHandler() {
		
		@Override
		public void onBuscarSource(BuscarSourceEvent event) {
			origen = event.getOrigen();
		}
	};
	
	@Inject DispatchAsync dispatchAsync;

	@Override
	protected void onBind() {
		super.onBind();
		
		getEventBus().addHandler(BuscarSourceEvent.getType(), buscarSourceHandler);

		getView().getCancelarButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getView().getLimpiarButton().click();
				getView().hide();
			}
		});
		
		getView().getLimpiarButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getView().getDniTextbox().setText("");
				getView().getPaterTextbox().setText("");
				getView().getMaterTexbox().setText("");
				getView().getNombreTextbox().setText("");
				getView().getDniTextbox().setFocus(true);
			}
		});
		
		getView().getBuscarButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {	
				if(getView().getDniTextbox().getText().isEmpty()){
					apaterno = getView().getPaterTextbox().getText();
				    amaterno = getView().getMaterTexbox().getText();
				    nombre = getView().getNombreTextbox().getText();
				    dni = "";
				    
				}
			    else{
			    	dni = getView().getDniTextbox().getText();
			    	apaterno = "";
				    amaterno = "";
				    nombre = "";
			    } 

			    GetPersona action= new GetPersona(nombre, apaterno, amaterno, dni);
				dispatchAsync.execute(action, getpersonaCallback);
			}
		});
		
		getView().getIngresarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {

				try{
					P selected = selection.getSelectedObject();
		            dni = selected.getDni();
		            apaterno = selected.getApaterno();
		            amaterno = selected.getAmaterno();
		            nombre = selected.getNombre();
		            cod_user = selected.getUsuario();
		            if (origen == "nuevorolalumno"){
		            	PlaceRequest request = new PlaceRequest(NameTokens.nuevorolalumno).with(
									"dni", dni).with(
									"nombres", nombre).with(
									"apaterno", apaterno).with(
									"amaterno", amaterno);				
						placeManager.revealPlace(request);
						getView().getCancelarButton().click();
		            }
		            if (origen == "nuevorolpsicologo"){
		            	PlaceRequest request = new PlaceRequest(NameTokens.nuevorolpsicologo).with(
									"dni", dni).with(
									"nombres", nombre).with(
									"apaterno", apaterno).with(
									"amaterno", amaterno).with(
									"cod_user", cod_user);		
						placeManager.revealPlace(request);
						getView().getCancelarButton().click();
		            }
		            if (origen == "nuevorolprofesor"){
		            	PlaceRequest request = new PlaceRequest(NameTokens.nuevorolprofesor).with(
									"dni", dni).with(
									"nombres", nombre).with(
									"apaterno", apaterno).with(
									"amaterno", amaterno).with(
											"cod_user", cod_user);				
						placeManager.revealPlace(request);
						getView().getCancelarButton().click();
		            }   
		            if (origen == "nuevorolpadre"){
		            	PlaceRequest request = new PlaceRequest(NameTokens.nuevorolpadre).with(
									"dni", dni).with(
									"nombres", nombre).with(
									"apaterno", apaterno).with(
									"amaterno", amaterno).with(
											"cod_user", cod_user);					
						placeManager.revealPlace(request);
						getView().getCancelarButton().click();
		            }

		            
				}catch (Exception a){
					Window.alert ("Seleccion un registro de la tabla, si esta vacia busque con otro termino");
				} 
			}
		});
		
		TextColumn<P> dnicolumn = new TextColumn<P>() {
			@Override
			public String getValue(P s) {
				return s.getDni();
			}
		};
		
		TextColumn<P> nombrecolumn = new TextColumn<P>() {
			@Override
			public String getValue(P s) {
				return s.getNombre();
			}
		};
		
		TextColumn<P> apaternocolumn = new TextColumn<P>() {
			@Override
			public String getValue(P s) {
				return s.getApaterno();
			}
		};
		
		TextColumn<P> amaternocolumn = new TextColumn<P>() {
			@Override
			public String getValue(P s) {
				return s.getAmaterno();
			}
		};
		
		getView().getCellTable().addColumn(dnicolumn, "DNI");
		getView().getCellTable().addColumn(nombrecolumn, "Nombre");
		getView().getCellTable().addColumn(apaternocolumn, "A.Paterno");
		getView().getCellTable().addColumn(amaternocolumn, "A.Materno");
		//getView().getCellTable().addColumn(usuarioocolumn, "Usuario");
		//agragando selecciones
		getView().getCellTable().setSelectionModel(selection);
		dataProvider.addDataDisplay(getView().getCellTable());
	}

	@Override
	protected void onReset() {
		super.onReset();
		List<P> list = dataProvider.getList();
		list.clear();
		getView().getLimpiarButton().click();
	}
	
	private AsyncCallback<GetPersonaResult> getpersonaCallback = new AsyncCallback<GetPersonaResult>() {
		
		@Override
		public void onSuccess(GetPersonaResult result) {
			List<P> list = dataProvider.getList();
			list.clear();
			List<P> listap = new ArrayList<P>();
			int i =0;
			while(i< result.getDni().size()){
				P p = new P(result.getDni().get(i),
						result.getNombre().get(i),
						result.getApparten().get(i),
						result.getApmatern().get(i),
						result.getCod_user().get(i));
				listap.add(p);
				i++;
			}
			
		    for (P p : listap) {
		      list.add(p);
		    }
		    
		}
		
		@Override
		public void onFailure(Throwable caught) {
		
			
		}
		
	};
	
	public class P {
		private String dni;
	    private String nombre;
	    private String apaterno;
	    private String amaterno;
	    private String usuario;
		
	    public P(){
	    	
	    }
	    
	    public P(String dni, String nombre, String apaterno, String amaterno, String usuario) {
			
			this.dni = dni;
			this.nombre = nombre;
			this.apaterno = apaterno;
			this.amaterno = amaterno;
			this.usuario = usuario;
		}

		public String getDni() {
			return dni;
		}

		public String getNombre() {
			return nombre;
		}

		public String getApaterno() {
			return apaterno;
		}

		public String getAmaterno() {
			return amaterno;
		}

		public String getUsuario() {
			return usuario;
		}

	}

}
