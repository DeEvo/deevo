package com.deevo.java.client;

import com.deevo.java.client.BuscarAulaPopupPresenter.C;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;

public class BuscarAulaPopupView extends PopupViewImpl implements
		BuscarAulaPopupPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, BuscarAulaPopupView> {
	}

	@Inject
	public BuscarAulaPopupView(final EventBus eventBus, final Binder binder) {
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
	@UiField Button ingresarButton;
	@UiField(provided=true) CellTable<C> cellTable = new CellTable<C>();
	@UiField TextBox cicloTextbox;
	@UiField TextBox periodoTextbox;
	@UiField TextBox gradoTextbox;
	@UiField TextBox seccionTexbox;
	
	public Button getBuscarButton() {
		return buscarButton;
	}

	public Button getLimpiarButton() {
		return limpiarButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public Button getIngresarButton() {
		return ingresarButton;
	}

	public CellTable<C> getCellTable() {
		return cellTable;
	}

	public TextBox getCicloTextbox() {
		return cicloTextbox;
	}

	public TextBox getPeriodoTextbox() {
		return periodoTextbox;
	}

	public TextBox getGradoTextbox() {
		return gradoTextbox;
	}

	public TextBox getSeccionTexbox() {
		return seccionTexbox;
	}

}
