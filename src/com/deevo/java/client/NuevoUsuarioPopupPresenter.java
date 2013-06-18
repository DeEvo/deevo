package com.deevo.java.client;

import com.deevo.java.client.event.MostrarPopupEvent;
import com.deevo.java.client.event.MostrarPopupEvent.MostrarPopupHandler;
import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public class NuevoUsuarioPopupPresenter extends
		PresenterWidget<NuevoUsuarioPopupPresenter.MyView> {

	public interface MyView extends PopupView {
		// TODO Put your view methods here
		public Label getMensaje() ;
		public Label getUsuario(); 
		public Label getContrasennia();
		public Button getBtnImprimir();
		public Button getBtnOk();
		
	}

	@Inject
	public NuevoUsuarioPopupPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}
	
	@Inject
	PlaceManager placeManager;
	
	public static String valor = null;
	public static String dni = null;
	public static String nombres = null;
	public static String apaterno = null;
	public static String amaterno = null;
	
	
	private MostrarPopupHandler MostrarPopupHandlerd = new MostrarPopupHandler(){

		@Override
		public void onMostrarPopup(MostrarPopupEvent event) {
			valor = event.getValor();
			dni = event.getDni();
			nombres = event.getNombres();
			apaterno = event.getApaterno();
			amaterno = event.getAmaterno();
		}
		
	};
	
	
	@Override
	protected void onBind() {
		super.onBind();
		
		getEventBus().addHandler(MostrarPopupEvent.getType(), MostrarPopupHandlerd);
		
		getView().getBtnOk().addClickHandler(new ClickHandler() {	
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						try {
							getView().hide();
							//MOVER ESTE CODIGO CUANDO SE HA VALIDADO
							if(valor == "alumno"){
								PlaceRequest request = new PlaceRequest(NameTokens.nuevorolalumno).with(
										"dni", dni).with(
										"nombres", nombres).with(
										"apaterno", apaterno).with(
										"amaterno", amaterno);				
								placeManager.revealPlace(request);
							}
							else if(valor == "padre"){
								PlaceRequest request = new PlaceRequest(NameTokens.nuevorolpadre).with(
										"dni", dni).with(
										"nombres", nombres).with(
										"apaterno", apaterno).with(
										"amaterno", amaterno);				
								placeManager.revealPlace(request);
							}
							else if(valor == "psicologo"){
								PlaceRequest request = new PlaceRequest(NameTokens.nuevorolpsicologo).with(
										"dni", dni).with(
										"nombres", nombres).with(
										"apaterno", apaterno).with(
										"amaterno", amaterno);					
								placeManager.revealPlace(request);
							}
							else if(valor == "profesor"){
								PlaceRequest request = new PlaceRequest(NameTokens.nuevorolprofesor).with(
										"dni", dni).with(
										"nombres", nombres).with(
										"apaterno", apaterno).with(
										"amaterno", amaterno);					
								placeManager.revealPlace(request);
							}
							
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
	}

	@Override
	protected void onReset() {
		super.onReset();
		
		
	}
}
