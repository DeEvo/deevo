package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

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
	@UiField TextBox estcivTexbox;
	@UiField DateBox fnacTexbox;
	@UiField IntegerBox telfTexbox;
	@UiField IntegerBox celTexbox;
	@UiField TextBox dirTexbox;
	@UiField IntegerBox emailTexbox;
	
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

	public TextBox getEstcivTexbox() {
		return estcivTexbox;
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

	public IntegerBox getEmailTexbox() {
		return emailTexbox;
	}

}
