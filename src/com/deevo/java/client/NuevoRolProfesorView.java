package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.cellview.client.CellTable;

public class NuevoRolProfesorView extends ViewImpl implements
		NuevoRolProfesorPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevoRolProfesorView> {
	}

	@UiField IntegerBox dniTexbox;
	@UiField TextBox nombresTexbox;
	@UiField TextBox apellidosTexbox;
	@UiField Button crearButton;
	@UiField Button  buscarButton;
	@UiField Button  cancelarButton;
	@UiField TextBox usuarioTexbox;
	@UiField TextBox  cursoTextbox;
	@UiField TextArea txtadescripcion;
	@UiField(provided=true) CellTable<Object> cellTable = new CellTable<Object>();
	@UiField(provided=true) CellTable<Object> cellTable_1 = new CellTable<Object>();
	@UiField Button quitarcursoBoton;
	@UiField Button asignarcursoBoton;
	@UiField CheckBox buscarcursoCheckbox;
	@UiField CheckBox descripcionCheckbox;
	@UiField Button limpiartablaButton;
	
	@Inject
	public NuevoRolProfesorView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}
	
	public IntegerBox getDniTexbox() {
		return dniTexbox;
	}

	public TextBox getNombresTexbox() {
		return nombresTexbox;
	}

	public TextBox getApellidosTexbox() {
		return apellidosTexbox;
	}

	@Override
	public Button getCrearButton() {
		// TODO Auto-generated method stub
		return crearButton;
	}

	public CellTable<Object> getCellTable() {
		return cellTable;
	}
	
	public CellTable<Object> getCellTable_1() {
		return cellTable_1;
	}
	
	public TextBox getContraTexbox() {
		return usuarioTexbox;
	}

	public TextArea getTxtadescripcion() {
		return txtadescripcion;
	}

	public TextBox getUsuarioTexbox() {
		return usuarioTexbox;
	}

	public Button getQuitarcursoBoton() {
		return quitarcursoBoton;
	}

	public Button getAsignarcursoBoton() {
		return asignarcursoBoton;
	}

	public CheckBox getBuscarcursoCheckbox() {
		return buscarcursoCheckbox;
	}

	public CheckBox getDescripcionCheckbox() {
		return descripcionCheckbox;
	}

	public Button getBuscarButton() {
		return buscarButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public TextBox getCursoTextbox() {
		return cursoTextbox;
	}

	public Button getLimpiartablaButton() {
		return limpiartablaButton;
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return widget;
	}
}
