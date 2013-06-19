package com.deevo.java.client;

import java.util.ArrayList;
import java.util.List;


//import com.deevo.java.client.BuscarPopupView.P;
import com.deevo.java.client.action.GetPersona;
import com.deevo.java.client.action.GetPersonaResult;
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
		public CellTable<P> getCellTable();
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
				campo = getView().getBuscarTextbox().getText();
			    
			    if (getView().getCampoListbox().getSelectedIndex() == 0){
			    	dni = campo;
			    }else if (getView().getCampoListbox().getSelectedIndex() == 1){
			    	apaterno  = campo;
			    }else if (getView().getCampoListbox().getSelectedIndex() == 2){
			    	amaterno  = campo;
			    }else if (getView().getCampoListbox().getSelectedIndex() == 3){
			    	nombre  = campo;
			    }
			    GetPersona action= new GetPersona(nombre, apaterno, amaterno, dni);
				dispatchAsync.execute(action, getpersonaCallback);
			}
		});
		
		/*TextColumn<P> dnicolumn = new TextColumn<BuscarPopupView.P>() {
			@Override
			public String getValue(P s) {
				return s.getDni();
			}
		};
		
		TextColumn<P> nombrecolumn = new TextColumn<BuscarPopupView.P>() {
			@Override
			public String getValue(P s) {
				return s.getNombre();
			}
		};
		
		TextColumn<P> apaternocolumn = new TextColumn<BuscarPopupView.P>() {
			@Override
			public String getValue(P s) {
				return s.getApaterno();
			}
		};
		
		TextColumn<P> amaternocolumn = new TextColumn<BuscarPopupView.P>() {
			@Override
			public String getValue(P s) {
				return s.getAmaterno();
			}
		};
		
		TextColumn<P> usuarioocolumn = new TextColumn<BuscarPopupView.P>() {
			@Override
			public String getValue(P s) {
				return s.getUsuario();
			}
		};*/
		
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
		
	}

	@Override
	protected void onReset() {
		super.onReset();

	}
	
	private AsyncCallback<GetPersonaResult> getpersonaCallback = new AsyncCallback<GetPersonaResult>() {
		
		@Override
		public void onSuccess(GetPersonaResult result) {
			// TODO Auto-generated method stub
			
			ListDataProvider<P> dataProvider = new ListDataProvider<P>();
			dataProvider.addDataDisplay(getView().getCellTable());
			
			List<P> list = dataProvider.getList();
			List<P> listap = new ArrayList<P>();
			int i =0;
			while(i< result.getDni().size()){
				P p = new P(result.getDni().get(i),
						result.getNombre().get(i),
						result.getApparten().get(i),
						result.getApmatern().get(i),
						null);
				listap.add(p);
				i++;
			}
			
		    for (P p : listap) {
		      list.add(p);
		    }
			
			//getView().getCellTable().setRowCount(result.getP().size(), true);
			//getView().getCellTable().setRowData(0, result.getP());

		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
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
