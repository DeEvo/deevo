package com.deevo.java.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.deevo.java.client.gin.ClientModule;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.gwt.inject.client.AsyncProvider;
import com.deevo.java.client.HomePresenter;
import com.deevo.java.client.MainPresenter;
import com.deevo.java.client.LayoutPresenter;
import com.deevo.java.client.LayoutMainPresenter;
import com.deevo.java.client.NuevaPersonaPresenter;
import com.deevo.java.client.BusquedaAlumnoPresenter;
import com.deevo.java.client.PerfilPresenter;
import com.deevo.java.client.EPsicomotrizPresenter;
import com.deevo.java.client.EFisicoPresenter;
import com.deevo.java.client.EAcademicoPresenter;
import com.deevo.java.client.BusquedaGrupoPresenter;
import com.deevo.java.client.EstadoGrupoPresenter;
import com.deevo.java.client.EstadisticasPresenter;
import com.deevo.java.client.EstadoAulaPresenter;
import com.deevo.java.client.EvaluacionInicialPresenter;
import com.deevo.java.client.BancoPreguntasPresenter;
import com.deevo.java.client.PruebasPsicomotizPresenter;
import com.deevo.java.client.SubirRespuestasPresenter;
import com.deevo.java.client.NuevaAlertaPresenter;
import com.deevo.java.client.BandejaAlertaPresenter;
import com.deevo.java.client.ElaborarPruebasPresenter;
import com.deevo.java.client.NuevoUsuarioPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<HomePresenter> getHomePresenter();

	AsyncProvider<MainPresenter> getMainPresenter();

	AsyncProvider<LayoutPresenter> getRootPresenter();

	AsyncProvider<LayoutMainPresenter> getLayoutMainPresenter();

	AsyncProvider<NuevaPersonaPresenter> getNuevaPersonaPresenter();

	AsyncProvider<BusquedaAlumnoPresenter> getBusquedaAlumnoPresenter();

	AsyncProvider<PerfilPresenter> getPerfilPresenter();

	AsyncProvider<EPsicomotrizPresenter> getEPsicomotrizPresenter();

	AsyncProvider<EFisicoPresenter> getEFisicoPresenter();

	AsyncProvider<EAcademicoPresenter> getEAcademicoPresenter();

	AsyncProvider<BusquedaGrupoPresenter> getBusquedaGrupoPresenter();

	AsyncProvider<EstadoGrupoPresenter> getEstadoGrupoPresenter();

	AsyncProvider<EstadisticasPresenter> getEstadisticasPresenter();

	AsyncProvider<EstadoAulaPresenter> getEstadoAulaPresenter();

	AsyncProvider<EvaluacionInicialPresenter> getEvaluacionInicialPresenter();

	AsyncProvider<BancoPreguntasPresenter> getBancoPreguntasPresenter();

	AsyncProvider<PruebasPsicomotizPresenter> getPruebasPsicomotizPresenter();

	AsyncProvider<SubirRespuestasPresenter> getSubirRespuestasPresenter();

	AsyncProvider<NuevaAlertaPresenter> getNuevaAlertaPresenter();

	AsyncProvider<BandejaAlertaPresenter> getBandejaAlertaPresenter();

	AsyncProvider<ElaborarPruebasPresenter> getElaborarPruebasPresenter();

	AsyncProvider<NuevoUsuarioPresenter> getNuevoUsuarioPresenter();

}
