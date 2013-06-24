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
import com.deevo.java.client.NuevoUsuarioPresenter;
import com.deevo.java.client.BusquedaAlumnoPresenter;
import com.deevo.java.client.VerPerfilPresenter;
import com.deevo.java.client.EPsicomotrizPresenter;
import com.deevo.java.client.EFisicoPresenter;
import com.deevo.java.client.EAcademicoPresenter;
import com.deevo.java.client.BusquedaAvanzadaPresenter;
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
import com.deevo.java.client.NuevoRolPsicologoPresenter;
import com.deevo.java.client.NuevoRolAlumnoPresenter;
import com.deevo.java.client.NuevoRolPadrePresenter;
import com.deevo.java.client.NuevoRolProfesorPresenter;
import com.deevo.java.client.NuevoCursoPresenter;
import com.deevo.java.client.NuevoGradoPresenter;
import com.deevo.java.client.NuevaSeccionPresenter;
import com.deevo.java.client.NuevoPeriodoPresenter;
import com.deevo.java.client.NuevaAulaPresenter;
import com.deevo.java.client.AsignarCursoAProfesorPresenter;
import com.deevo.java.client.HabilitarCursoPresenter;
import com.deevo.java.client.BusquedaPorAulaPresenter;
import com.deevo.java.client.VerAulaPresenter;
import com.deevo.java.client.VerCursoPresenter;
import com.deevo.java.client.VerProfesorPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<HomePresenter> getHomePresenter();

	AsyncProvider<MainPresenter> getMainPresenter();

	AsyncProvider<LayoutPresenter> getRootPresenter();

	AsyncProvider<LayoutMainPresenter> getLayoutMainPresenter();

	AsyncProvider<NuevoUsuarioPresenter> getNuevaPersonaPresenter();

	AsyncProvider<BusquedaAlumnoPresenter> getBusquedaAlumnoPresenter();

	AsyncProvider<VerPerfilPresenter> getVerPerfilPresenter();

	AsyncProvider<EPsicomotrizPresenter> getEPsicomotrizPresenter();

	AsyncProvider<EFisicoPresenter> getEFisicoPresenter();

	AsyncProvider<EAcademicoPresenter> getEAcademicoPresenter();

	AsyncProvider<BusquedaAvanzadaPresenter> getBusquedaAvanzadaPresenter();

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

	AsyncProvider<NuevoRolPsicologoPresenter> getNuevoUsuarioPresenter();

	AsyncProvider<NuevoRolAlumnoPresenter> getNuevoAlumnoPresenter();

	AsyncProvider<NuevoRolPadrePresenter> getNuevoRolPadrePresenter();

	AsyncProvider<NuevoRolProfesorPresenter> getNuevoRolProfesorPresenter();

	AsyncProvider<NuevoCursoPresenter> getNuevoCursoPresenter();

	AsyncProvider<NuevoGradoPresenter> getNuevoGradoPresenter();

	AsyncProvider<NuevaSeccionPresenter> getNuevaSeccionPresenter();

	AsyncProvider<NuevoPeriodoPresenter> getNuevoPeriodoPresenter();

	AsyncProvider<NuevaAulaPresenter> getNuevaAulaPresenter();

	AsyncProvider<AsignarCursoAProfesorPresenter> getAsignarCursoAProfesorPresenter();

	AsyncProvider<HabilitarCursoPresenter> getHabilitarCursoPresenter();

	AsyncProvider<BusquedaPorAulaPresenter> getBusquedaPorAulaPresenter();

	AsyncProvider<VerAulaPresenter> getVerAulaPresenter();

	AsyncProvider<VerCursoPresenter> getVerCursoPresenter();

	AsyncProvider<VerProfesorPresenter> getVerProfesorPresenter();

}