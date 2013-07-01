package com.deevo.java.client;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;

public class BuscarAulaPopupPresenter extends
		PresenterWidget<BuscarAulaPopupPresenter.MyView> {

	public interface MyView extends PopupView {
		
		public Button getBuscarButton();
		public Button getLimpiarButton();
		public Button getCancelarButton();
		public Button getIngresarButton();
		public CellTable<C> getCellTable();
		public TextBox getCicloTextbox();
		public TextBox getPeriodoTextbox();
		public TextBox getGradoTextbox();
		public TextBox getSeccionTexbox();
	}

	private String periodo;
	private String ciclo;
	private String grado;
    private String seccion;
    
	private ListDataProvider<C> dataProvider = new ListDataProvider<C>();
	
	private SingleSelectionModel<C> selection = new SingleSelectionModel<C>();
	
	@Inject
	public BuscarAulaPopupPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		TextColumn<C> periodocolumn = new TextColumn<C>() {
			@Override
			public String getValue(C s) {
				return s.getPeriodo();
			}
		};
		
		TextColumn<C> ciclocolumn = new TextColumn<C>() {
			@Override
			public String getValue(C s) {
				return s.getCiclo();
			}
		};
		
		TextColumn<C> gradoocolumn = new TextColumn<C>() {
			@Override
			public String getValue(C s) {
				return s.getGrado();
			}
		};
		
		TextColumn<C> seccioncolumn = new TextColumn<C>() {
			@Override
			public String getValue(C s) {
				return s.getSeccion();
			}
		};
		
		getView().getCellTable().addColumn(periodocolumn, "Periodo");
		getView().getCellTable().addColumn(ciclocolumn, "Ciclo");
		getView().getCellTable().addColumn(gradoocolumn, "Grado");
		getView().getCellTable().addColumn(seccioncolumn, "Seccion");

		//agragando selecciones
		getView().getCellTable().setSelectionModel(selection);
		dataProvider.addDataDisplay(getView().getCellTable());
	}
	
	public class C {
		private String periodo;
		private String ciclo;
		private String grado;
		private String seccion;
		
		public C(){
			
		}

		public C(String periodo, String ciclo, String grado, String seccion) {

			this.periodo = periodo;
			this.ciclo = ciclo;
			this.grado = grado;
			this.seccion = seccion;
		}

		public String getPeriodo() {
			return periodo;
		}

		public String getCiclo() {
			return ciclo;
		}

		public String getGrado() {
			return grado;
		}

		public String getSeccion() {
			return seccion;
		}

	}
}
