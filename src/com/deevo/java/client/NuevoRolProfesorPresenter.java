package com.deevo.java.client;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.action.NuevoProfesor;
import com.deevo.java.client.action.NuevoProfesorResult;
import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class NuevoRolProfesorPresenter extends
		Presenter<NuevoRolProfesorPresenter.MyView, NuevoRolProfesorPresenter.MyProxy> {

	public interface MyView extends View {
		public IntegerBox getDniTexbox();
		public TextBox getNombresTexbox();
		public TextBox getApellidosTexbox();
		public Button getCrearButton();
		public TextBox getContraTexbox();
		public TextArea getTxtadescripcion();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.nuevorolprofesor)
	public interface MyProxy extends ProxyPlace<NuevoRolProfesorPresenter> {
	}

	@Inject
	public NuevoRolProfesorPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutMainPresenter.SLOT_SetMainContent, this);
	}

	private String dni ="";
	private String nombres ="";
	private String apellidos ="";
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		dni= request.getParameter("dni", "");
		nombres= request.getParameter("nombres", "");
		apellidos= request.getParameter("apaterno", "") +" "+ request.getParameter("amaterno", "");
	}
	
	@Override
	protected void onBind() {
		super.onBind();
	}
	
	@Inject DispatchAsync async;
	
	@Override
	protected void onReset() {
		super.onReset();
		getView().getDniTexbox().setText(dni);
		getView().getNombresTexbox().setText(nombres);
		getView().getApellidosTexbox().setText(apellidos); 
		
		
	   getView().getCrearButton().addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			List<String> list = new ArrayList<String>();
			list.add("2");
			NuevoProfesor nuevoprofesor = new NuevoProfesor(
					getView().getDniTexbox().getText(),
					getView().getTxtadescripcion().getText(),
					list,
					"",
					1);
			async.execute(nuevoprofesor, getAsyncCallback);
		}
	});
		
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
	}
