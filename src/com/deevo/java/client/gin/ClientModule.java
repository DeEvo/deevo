package com.deevo.java.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.deevo.java.client.place.ClientPlaceManager;
import com.deevo.java.client.place.DefaultPlace;
import com.deevo.java.client.place.NameTokens;
import com.deevo.java.client.HomePresenter;
import com.deevo.java.client.HomeView;
import com.deevo.java.client.LoginPresenter;
import com.deevo.java.client.LoginView;
import com.deevo.java.client.MainPresenter;
import com.deevo.java.client.MainView;
import com.deevo.java.client.NuevaPersonaPresenter;
import com.deevo.java.client.NuevaPersonaView;
import com.deevo.java.client.LayoutPresenter;
import com.deevo.java.client.LayoutView;
import com.deevo.java.client.HeaderPresenter;
import com.deevo.java.client.HeaderView;
import com.deevo.java.client.FooterPresenter;
import com.deevo.java.client.FooterView;
import com.deevo.java.client.LayoutMainPresenter;
import com.deevo.java.client.LayoutMainView;
import com.deevo.java.client.MenuAdminPresenter;
import com.deevo.java.client.MenuAdminView;
import com.deevo.java.client.SesionPresenter;
import com.deevo.java.client.SesionView;
import com.deevo.java.client.MenuPsicologoPresenter;
import com.deevo.java.client.MenuPsicologoView;
import com.deevo.java.client.BusquedaAlumnoPresenter;
import com.deevo.java.client.BusquedaAlumnoView;
import com.deevo.java.client.PerfilPresenter;
import com.deevo.java.client.PerfilView;
import com.deevo.java.client.EPsicomotrizPresenter;
import com.deevo.java.client.EPsicomotrizView;
import com.deevo.java.client.EFisicoPresenter;
import com.deevo.java.client.EFisicoView;
import com.deevo.java.client.EAcademicoPresenter;
import com.deevo.java.client.EAcademicoView;
import com.deevo.java.client.BusquedaGrupoPresenter;
import com.deevo.java.client.BusquedaGrupoView;
import com.deevo.java.client.EstadoGrupoPresenter;
import com.deevo.java.client.EstadoGrupoView;
import com.deevo.java.client.EstadisticasPresenter;
import com.deevo.java.client.EstadisticasView;
import com.deevo.java.client.EstadoAulaPresenter;
import com.deevo.java.client.EstadoAulaView;
import com.deevo.java.client.EvaluacionInicialPresenter;
import com.deevo.java.client.EvaluacionInicialView;
import com.deevo.java.client.BancoPreguntasPresenter;
import com.deevo.java.client.BancoPreguntasView;
import com.deevo.java.client.PruebasPsicomotizPresenter;
import com.deevo.java.client.PruebasPsicomotizView;
import com.deevo.java.client.SubirRespuestasPresenter;
import com.deevo.java.client.SubirRespuestasView;
import com.deevo.java.client.NuevaAlertaPresenter;
import com.deevo.java.client.NuevaAlertaView;
import com.deevo.java.client.BandejaAlertaPresenter;
import com.deevo.java.client.BandejaAlertaView;
import com.deevo.java.client.ElaborarPruebasPresenter;
import com.deevo.java.client.ElaborarPruebasView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);

		bindPresenter(HomePresenter.class, HomePresenter.MyView.class,
				HomeView.class, HomePresenter.MyProxy.class);

		bindPresenter(MainPresenter.class, MainPresenter.MyView.class,
				MainView.class, MainPresenter.MyProxy.class);

		bindPresenter(LayoutPresenter.class, LayoutPresenter.MyView.class,
				LayoutView.class, LayoutPresenter.MyProxy.class);
		
		bindPresenter(LayoutMainPresenter.class,
				LayoutMainPresenter.MyView.class, LayoutMainView.class,
				LayoutMainPresenter.MyProxy.class);

		bindPresenterWidget(LoginPresenter.class, LoginPresenter.MyView.class,
				LoginView.class);

		bindPresenterWidget(HeaderPresenter.class,
				HeaderPresenter.MyView.class, HeaderView.class);

		bindPresenterWidget(FooterPresenter.class,
				FooterPresenter.MyView.class, FooterView.class);

		bindPresenterWidget(MenuAdminPresenter.class,
				MenuAdminPresenter.MyView.class, MenuAdminView.class);
	

		bindPresenterWidget(SesionPresenter.class,
				SesionPresenter.MyView.class, SesionView.class);

		bindPresenter(NuevaPersonaPresenter.class,
				NuevaPersonaPresenter.MyView.class, NuevaPersonaView.class,
				NuevaPersonaPresenter.MyProxy.class);


		bindPresenterWidget(MenuPsicologoPresenter.class,
				MenuPsicologoPresenter.MyView.class, MenuPsicologoView.class);

		bindPresenter(BusquedaAlumnoPresenter.class,
				BusquedaAlumnoPresenter.MyView.class, BusquedaAlumnoView.class,
				BusquedaAlumnoPresenter.MyProxy.class);

		bindPresenter(PerfilPresenter.class, PerfilPresenter.MyView.class,
				PerfilView.class, PerfilPresenter.MyProxy.class);

		bindPresenter(EPsicomotrizPresenter.class,
				EPsicomotrizPresenter.MyView.class, EPsicomotrizView.class,
				EPsicomotrizPresenter.MyProxy.class);

		bindPresenter(EFisicoPresenter.class, EFisicoPresenter.MyView.class,
				EFisicoView.class, EFisicoPresenter.MyProxy.class);

		bindPresenter(EAcademicoPresenter.class,
				EAcademicoPresenter.MyView.class, EAcademicoView.class,
				EAcademicoPresenter.MyProxy.class);

		bindPresenter(BusquedaGrupoPresenter.class,
				BusquedaGrupoPresenter.MyView.class, BusquedaGrupoView.class,
				BusquedaGrupoPresenter.MyProxy.class);

		bindPresenter(EstadoGrupoPresenter.class,
				EstadoGrupoPresenter.MyView.class, EstadoGrupoView.class,
				EstadoGrupoPresenter.MyProxy.class);

		bindPresenter(EstadisticasPresenter.class,
				EstadisticasPresenter.MyView.class, EstadisticasView.class,
				EstadisticasPresenter.MyProxy.class);

		bindPresenter(EstadoAulaPresenter.class,
				EstadoAulaPresenter.MyView.class, EstadoAulaView.class,
				EstadoAulaPresenter.MyProxy.class);

		bindPresenter(EvaluacionInicialPresenter.class,
				EvaluacionInicialPresenter.MyView.class,
				EvaluacionInicialView.class,
				EvaluacionInicialPresenter.MyProxy.class);

		bindPresenter(BancoPreguntasPresenter.class,
				BancoPreguntasPresenter.MyView.class, BancoPreguntasView.class,
				BancoPreguntasPresenter.MyProxy.class);

		bindPresenter(PruebasPsicomotizPresenter.class,
				PruebasPsicomotizPresenter.MyView.class,
				PruebasPsicomotizView.class,
				PruebasPsicomotizPresenter.MyProxy.class);

		bindPresenter(SubirRespuestasPresenter.class,
				SubirRespuestasPresenter.MyView.class,
				SubirRespuestasView.class,
				SubirRespuestasPresenter.MyProxy.class);

		bindPresenter(NuevaAlertaPresenter.class,
				NuevaAlertaPresenter.MyView.class, NuevaAlertaView.class,
				NuevaAlertaPresenter.MyProxy.class);

		bindPresenter(BandejaAlertaPresenter.class,
				BandejaAlertaPresenter.MyView.class, BandejaAlertaView.class,
				BandejaAlertaPresenter.MyProxy.class);

		bindPresenter(ElaborarPruebasPresenter.class,
				ElaborarPruebasPresenter.MyView.class,
				ElaborarPruebasView.class,
				ElaborarPruebasPresenter.MyProxy.class);
	}
}
