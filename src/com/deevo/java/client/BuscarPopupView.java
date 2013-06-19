package com.deevo.java.client;

import com.deevo.java.shared.Persona;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.cellview.client.CellTable;

public class BuscarPopupView extends PopupViewImpl implements
		BuscarPopupPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, BuscarPopupView> {
	}

	@Inject
	public BuscarPopupView(final EventBus eventBus, final Binder binder) {
		super(eventBus);
		widget = binder.createAndBindUi(this);
	}
	
	

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@UiField Button limpiarButton;
	@UiField Button buscarButton;
	@UiField Button cancelarButton;
	@UiField ListBox campoListbox;
	@UiField TextBox buscarTextbox;
	@UiField Button ingresarButton;
	@UiField(provided=true) CellTable<Persona> cellTable = new CellTable<Persona>();
	
	public Button getLimpiarButton() {
		return limpiarButton;
	}

	public Button getBuscarButton() {
		return buscarButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public ListBox getCampoListbox() {
		return campoListbox;
	}

	public TextBox getBuscarTextbox() {
		return buscarTextbox;
	}

	public Button getIngresarButton() {
		return ingresarButton;
	}

	public CellTable<Persona> getCellTable() {
		return cellTable;
	}
	
	
	/*public class Persona {
		private String dni;
	    private String nombre;
	    private String apaterno;
	    private String amaterno;
	    private String usuario;
		
	    public Persona(String dni, String nombre, String apaterno, String amaterno, String usuario) {
			super();
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

	}*/
	
}



