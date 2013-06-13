package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.ChangeEvent;

public class NuevaPersonaView extends ViewImpl implements
		NuevaPersonaPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, NuevaPersonaView> {
	}

	@UiField Button ingresarButton;
	@UiField IntegerBox dniTexbox;
	@UiField TextBox nombresTexbox;
	@UiField TextBox appaternTexbox;
	@UiField TextBox apmaternTexbox;
	@UiField ListBox estcivListbox;
	@UiField DateBox fnacTexbox;
	@UiField IntegerBox telfTexbox;
	@UiField IntegerBox celTexbox;
	@UiField TextBox dirTexbox;
	@UiField TextBox emailTexbox;
	@UiField TextBox txtvalida;
	
	@Inject
	public NuevaPersonaView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	public Button getIngresarButton() {
		return ingresarButton;
	}

	public IntegerBox getDniTexbox() {
		return dniTexbox;
	}

	public TextBox getNombresTexbox() {
		return nombresTexbox;
	}

	public TextBox getAppaternTexbox() {
		return appaternTexbox;
	}

	public TextBox getApmaternTexbox() {
		return apmaternTexbox;
	}

	public ListBox getEstcivListbox() {
		return estcivListbox;
	}

	public DateBox getFnacTexbox() {
		return fnacTexbox;
	}

	public IntegerBox getTelfTexbox() {
		return telfTexbox;
	}

	public IntegerBox getCelTexbox() {
		return celTexbox;
	}

	public TextBox getDirTexbox() {
		return dirTexbox;
	}

	public TextBox getEmailTexbox() {
		return emailTexbox;
	}
	
// VALIDACION DE TIPO DE DATOS
	//NUEMRICOS
	@UiHandler("dniTexbox")
	void onDniTexboxKeyPress(KeyPressEvent event) {
		char c = event.getCharCode();
	    if (!(c >= 48 && c <= 57)) {
	    	((IntegerBox)event.getSource()).cancelKey();
	    }

	}

	
	@UiHandler("telfTexbox")
	void onTelfTexboxKeyPress(KeyPressEvent event) {
		char c = event.getCharCode();
	    if (!(c >= 48 && c <= 57)) {
	    	((IntegerBox)event.getSource()).cancelKey();
	    }
	}
	
	@UiHandler("celTexbox")
	void onCelTexboxKeyPress(KeyPressEvent event) {
		char c = event.getCharCode();
	    if (!(c >= 48 && c <= 57)) {
	    	((IntegerBox)event.getSource()).cancelKey();
	    }
	}
	
	//LETRAS, ESPACIOS EN BLANCO Y -
	
	@UiHandler("nombresTexbox")
	void onNombresTexboxKeyPress(KeyPressEvent event) {
		char c = event.getCharCode();
	    if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 45 || c == 32)) {
	    	((TextBox)event.getSource()).cancelKey();
	    }
	}
	
	@UiHandler("appaternTexbox")
	void onAppaternTexboxKeyPress(KeyPressEvent event) {
		char c = event.getCharCode();
	    if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 45 || c == 32)) {
	    	((TextBox)event.getSource()).cancelKey();
	    }
	}
	
	@UiHandler("apmaternTexbox")
	void onApmaternTexboxKeyPress(KeyPressEvent event) {
		char c = event.getCharCode();
	    if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 45 || c == 32)) {
	    	((TextBox)event.getSource()).cancelKey();
	    }
	}	      

	
	@UiHandler("txtvalida")
	void onTxtvalidaChange(ChangeEvent event) {
	    if(dniTexbox.getText().length() != 8){
	    	//txtvalida.addStyleName();
	    	txtvalida.setText("Incorrecto");
	    }else{
	    	txtvalida.setText("Correcto");
	    }
		
	}
}
