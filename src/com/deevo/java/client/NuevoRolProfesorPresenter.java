package com.deevo.java.client;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.action.GetCursos;
import com.deevo.java.client.action.GetCursosResult;
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
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;

public class NuevoRolProfesorPresenter extends
		Presenter<NuevoRolProfesorPresenter.MyView, NuevoRolProfesorPresenter.MyProxy> {

	public interface MyView extends View {
		public IntegerBox getDniTexbox();
		public TextBox getNombresTexbox() ;
		public TextBox getApellidosTexbox() ;
		public Button getCrearButton();
		public CellTable<C> getCellTable() ;
		public CellTable<C> getCellTable_1();
		public TextArea getTxtadescripcion();
		public TextBox getUsuarioTexbox();
		public Button getQuitarcursoBoton();
		public Button getAsignarcursoBoton();
		public CheckBox getBuscarcursoCheckbox();
		public Button getBuscarButton();
		public Button getCancelarButton();
		public TextBox getCursoTextbox();
		public Button getLimpiartablaButton();
		public Button getBuscarcursoButton();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.nuevorolprofesor)
	public interface MyProxy extends ProxyPlace<NuevoRolProfesorPresenter> {
	}

	@Inject BuscarPersonaPopupPresenter buscarpersonaPopPresenter;
	private EventBus eventbus;
	@Inject
	public NuevoRolProfesorPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
		super(eventBus, view, proxy);
		this.eventbus = eventBus;
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutMainPresenter.SLOT_SetMainContent, this);
	}

	private String dni ="";
	private String nombres ="";
	private List<String> cod_cur = new ArrayList<String>();
	private String apellidos ="";
	private String cod_user = "";
	
	private ListDataProvider<C> dataProvider = new ListDataProvider<C>();
	private SingleSelectionModel<C> selection = new SingleSelectionModel<C>();
	private ListDataProvider<C> dataProvider_1 = new ListDataProvider<C>();
	private SingleSelectionModel<C> selection_1 = new SingleSelectionModel<C>();
	
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

		/*TextColumn<C> cod_curcolumn = new TextColumn<C>() {
			@Override
			public String getValue(C s) {
				return s.getCod_cur();
			}
		};*/
		TextColumn<C> cur_tipcolumn = new TextColumn<C>() {
			@Override
			public String getValue(C s) {
				return s.getCur_tip();
			}
		};
		
		TextColumn<C> cur_nomcolumn = new TextColumn<C>() {
			@Override
			public String getValue(C s) {
				return s.getCur_nom();
			}
		};
		
		TextColumn<C> cur_descolumn = new TextColumn<C>() {
			@Override
			public String getValue(C s) {
				return s.getCur_des();
			}
		};
		
		//Agregando COlumnas
		//getView().getCellTable().addColumn(cod_curcolumn, "Cod_Curso");
		getView().getCellTable().addColumn(cur_nomcolumn, "Nombre");
		getView().getCellTable().addColumn(cur_tipcolumn, "Tipo");
		getView().getCellTable().addColumn(cur_descolumn, "Desc");
		
		//getView().getCellTable_1().addColumn(cod_curcolumn, "Cod_Curso");
		getView().getCellTable_1().addColumn(cur_nomcolumn, "Nombre");
		getView().getCellTable_1().addColumn(cur_tipcolumn, "Tipo");
		getView().getCellTable_1().addColumn(cur_descolumn, "Desc");
		
	   getView().getCrearButton().addClickHandler(new ClickHandler() {	
		@Override
		public void onClick(ClickEvent event) {
			List<String> list = new ArrayList<String>();
			if(getView().getBuscarcursoCheckbox().isAttached()){
				if(cod_cur.size() > 0){
					int i= 0;
					while(i< cod_cur.size()){
						list.add(cod_cur.get(i));
						i++;
					}
				}
			}
			NuevoProfesor nuevoprofesor = new NuevoProfesor(
					getView().getDniTexbox().getText(),
					getView().getTxtadescripcion().getText(),
					list,
					"",
					1);
			async.execute(nuevoprofesor, getAsyncCallback);
		}
	});
		
	  getView().getBuscarButton().addClickHandler(new ClickHandler() {	
		@Override
		public void onClick(ClickEvent event) {
			BuscarSourceEvent eventbuscar = new BuscarSourceEvent("nuevorolprofesor");
			NuevoRolProfesorPresenter.this.eventbus.fireEvent(eventbuscar);
			addToPopupSlot(buscarpersonaPopPresenter);
		}
	});
	  
	  getView().getCellTable().setSelectionModel(selection);
		dataProvider.addDataDisplay(getView().getCellTable());
		
		getView().getCellTable_1().setSelectionModel(selection_1);
		dataProvider_1.addDataDisplay(getView().getCellTable_1());
		
	  //nombres de ta bla
	  getView().getCellTable().setTitle("Cursos Buscados");
	  getView().getCellTable_1().setTitle("Cursos Asigandos");
	  // busquead de cursos
	getView().getBuscarcursoButton().addClickHandler(new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			String cur = getView().getCursoTextbox().getText();
			GetCursos action= new GetCursos(cur);
			dispatchAsync.execute(action, getcursosAsyncCallback);
		}
	});
	  //Asigancion de curso
	 getView().getAsignarcursoBoton().addClickHandler(new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			List<C> list = dataProvider_1.getList();
			C c = selection.getSelectedObject();
			if( c!= null){
				if(!list.contains(selection.getSelectedObject())){
					list.add(selection.getSelectedObject());
					cod_cur.add(selection.getSelectedObject().getCod_cur());
					selection_1.setSelected(selection.getSelectedObject(), true);
					selection.clear();
				}else{
					selection_1.setSelected(selection.getSelectedObject(), true);
					selection.clear();
				}
			}	
		}
	}); 
	 //quitar cursos de la lista
	 getView().getQuitarcursoBoton().addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			List<C> list = dataProvider_1.getList();
				C c = selection_1.getSelectedObject();
				if(c != null){
					list.remove(selection_1.getSelectedObject());
					cod_cur.remove(selection_1.getSelectedObject().getCod_cur());
				}		
		}
	});
	 
	 getView().getLimpiartablaButton().addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			 List<C> list = dataProvider.getList();
			 List<C> list1 = dataProvider_1.getList();
			 list.clear();
			 list1.clear();
		}
	});
	}
	
	@Inject DispatchAsync async;
	
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
		 getView().getCursoTextbox().setText("");
		 getView().getBuscarcursoCheckbox().setValue(false);
		 getView().getTxtadescripcion().setText("");
		 List<C> list = dataProvider.getList();
		 List<C> list1 = dataProvider_1.getList();
		 list.clear();
		 list1.clear();
	 }
	
	
	private AsyncCallback<NuevoProfesorResult> getAsyncCallback = new AsyncCallback<NuevoProfesorResult>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(NuevoProfesorResult result) {
			Window.alert(result.getMensaje());
			
		}
		
		
		
	};
	
	private AsyncCallback<GetCursosResult> getcursosAsyncCallback = new AsyncCallback<GetCursosResult>(){

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("falla");
		}

		@Override
		public void onSuccess(GetCursosResult result) {
			
			
			
			List<C> list = dataProvider.getList();
			list.clear();
			List<C> listac = new ArrayList<C>();
			int i =0;
			while(i< result.getCodCur().size()){
				C c = new C(result.getCodCur().get(i),
						result.getCurTip().get(i),
						result.getCurNom().get(i),
						result.getCurDes().get(i)
						);
				listac.add(c);
				i++;
			}
			
		    for (C c : listac) {
		      list.add(c);
		    }
		}	
	};
	
	public class C {
		private String cod_cur;
	    private String cur_tip;
	    private String cur_nom;
	    private String cur_des;
		
	    public C(){
	    	
	    }
	    
	    public C(String cod_cur, String cur_tip, String cur_nom, String cur_des) {
			
			this.cod_cur = cod_cur;
			this.cur_tip = cur_tip;
			this.cur_nom = cur_nom;
			this.cur_des = cur_des;
		}

		public String getCod_cur() {
			return cod_cur;
		}

		public String getCur_tip() {
			return cur_tip;
		}

		public String getCur_nom() {
			return cur_nom;
		}

		public String getCur_des() {
			return cur_des;
		}
	}
	}
