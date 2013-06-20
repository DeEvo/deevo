package com.deevo.java.client;

import com.deevo.java.client.BuscarPopupPresenter.P;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
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
	
	@UiField Button buscarButton;
	@UiField Button limpiarButton;
	@UiField Button cancelarButton;
	@UiField TextBox dniTextbox;
	@UiField TextBox apaternoTextbox;
	@UiField TextBox amaternoTextbox;
	@UiField TextBox nombreTextbox;
	@UiField Button ingresarButton;
	@UiField(provided=true) CellTable<P> cellTable = new CellTable<P>();
	
	public Button getLimpiarButton() {
		return limpiarButton;
	}

	public Button getBuscarButton() {
		return buscarButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public Button getIngresarButton() {
		return ingresarButton;
	}
	
	public TextBox getDniTextbox() {
		return dniTextbox;
	}

	public TextBox getApaternoTextbox() {
		return apaternoTextbox;
	}

	public TextBox getAmaternoTextbox() {
		return amaternoTextbox;
	}

	public TextBox getNombreTextbox() {
		return nombreTextbox;
	}

	public CellTable<P> getCellTable() {
		return cellTable;
	}

	public Widget getWidget() {
		return widget;
	}
	
}



