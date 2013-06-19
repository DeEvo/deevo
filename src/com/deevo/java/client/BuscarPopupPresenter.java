package com.deevo.java.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.deevo.java.shared.Persona;
//import com.deevo.java.client.BuscarPopupView.Persona;
import com.deevo.java.client.action.GetPersona;
import com.deevo.java.client.action.GetPersonaResult;
import com.deevo.java.client.action.NuevaPersonaResult;
import com.deevo.java.client.event.BuscarSourceEvent;
import com.deevo.java.client.event.BuscarSourceEvent.BuscarSourceHandler;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.ListDataProvider;



public class BuscarPopupPresenter extends
		PresenterWidget<BuscarPopupPresenter.MyView> {

	public interface MyView extends PopupView {
		// TODO Put your view methods here
		public Button getLimpiarButton();
		public Button getBuscarButton();
		public Button getCancelarButton();
		public ListBox getCampoListbox();
		public TextBox getBuscarTextbox();
		public CellTable<Persona> getCellTable();
	}
	
	private String campo;
	private String dni;
    private String nombre;
    private String apaterno;
    private String amaterno;
         
	@Inject
	public BuscarPopupPresenter(final EventBus eventBus, final MyView view) {
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
		
		getView().getBuscarButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				campo = getView().getCampoListbox().getItemText(getView().getCampoListbox().getSelectedIndex());
			    
			    if (getView().getCampoListbox().getSelectedIndex() == 0){
			    	dni = campo;
			    }else if (getView().getCampoListbox().getSelectedIndex() == 1){
			    	apaterno  = campo;
			    }else if (getView().getCampoListbox().getSelectedIndex() == 2){
			    	amaterno  = campo;
			    }else if (getView().getCampoListbox().getSelectedIndex() == 3){
			    	nombre  = campo;
			    }
			    //GetPersona action= new GetPersona(nombre, apaterno, amaterno, dni);
				//dispatchAsync.execute(action, getpersonaCallback);
			}
		});
		
		/*TextColumn<Persona> dnicolumn = new TextColumn<BuscarPopupView.Persona>() {
			@Override
			public String getValue(Persona s) {
				return s.getDni();
			}
		};
		
		TextColumn<Persona> nombrecolumn = new TextColumn<BuscarPopupView.Persona>() {
			@Override
			public String getValue(Persona s) {
				return s.getNombre();
			}
		};
		
		TextColumn<Persona> apaternocolumn = new TextColumn<BuscarPopupView.Persona>() {
			@Override
			public String getValue(Persona s) {
				return s.getApaterno();
			}
		};
		
		TextColumn<Persona> amaternocolumn = new TextColumn<BuscarPopupView.Persona>() {
			@Override
			public String getValue(Persona s) {
				return s.getAmaterno();
			}
		};
		
		TextColumn<Persona> usuarioocolumn = new TextColumn<BuscarPopupView.Persona>() {
			@Override
			public String getValue(Persona s) {
				return s.getUsuario();
			}
		};*/
		
		TextColumn<Persona> dnicolumn = new TextColumn<Persona>() {
			@Override
			public String getValue(Persona s) {
				return s.getPerDni();
			}
		};
		
		TextColumn<Persona> nombrecolumn = new TextColumn<Persona>() {
			@Override
			public String getValue(Persona s) {
				return s.getPerNom();
			}
		};
		
		TextColumn<Persona> apaternocolumn = new TextColumn<Persona>() {
			@Override
			public String getValue(Persona s) {
				return s.getPerPat();
			}
		};
		
		TextColumn<Persona> amaternocolumn = new TextColumn<Persona>() {
			@Override
			public String getValue(Persona s) {
				return s.getPerMat();
			}
		};
		
		getView().getCellTable().addColumn(dnicolumn, "DNI");
		getView().getCellTable().addColumn(nombrecolumn, "Nombre");
		getView().getCellTable().addColumn(apaternocolumn, "A.Paterno");
		getView().getCellTable().addColumn(amaternocolumn, "A.Materno");
		//getView().getCellTable().addColumn(usuarioocolumn, "Usuario");
		
	}

	@Override
	protected void onReset() {
		super.onReset();

	}
	
	/*private AsyncCallback<GetPersonaResult> getpersonaCallback = new AsyncCallback<GetPersonaResult>() {
		
		@Override
		public void onSuccess(GetPersonaResult result) {
			// TODO Auto-generated method stub
			
			ListDataProvider<Persona> dataProvider = new ListDataProvider<Persona>();
			dataProvider.addDataDisplay(getView().getCellTable());
			
			List<Persona> list = dataProvider.getList();
		    for (Persona persona : result.getPersona()) {
		      list.add(persona);
		    }
			
			//getView().getCellTable().setRowCount(result.getPersona().size(), true);
			//getView().getCellTable().setRowData(0, result.getPersona());

		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
		
	};*/

}
