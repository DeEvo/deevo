package com.deevo.java.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.deevo.java.client.place.ClientPlaceManager;
import com.deevo.java.client.place.DefaultPlace;
import com.deevo.java.client.place.NameTokens;
import com.deevo.java.client.BodyPresenter;
import com.deevo.java.client.BodyView;
import com.deevo.java.client.HomePresenter;
import com.deevo.java.client.HomeView;
import com.deevo.java.client.LoginPresenter;
import com.deevo.java.client.LoginView;
import com.deevo.java.client.MainPresenter;
import com.deevo.java.client.MainView;
import com.deevo.java.client.PerfilPresenter;
import com.deevo.java.client.PerfilView;
import com.deevo.java.client.EstudiantesPresenter;
import com.deevo.java.client.EstudiantesView;
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
		
		bindPresenterWidget(BodyPresenter.class, BodyPresenter.MyView.class,
				BodyView.class);

		bindPresenterWidget(PerfilPresenter.class,
				PerfilPresenter.MyView.class, PerfilView.class);

		bindPresenterWidget(EstudiantesPresenter.class,
				EstudiantesPresenter.MyView.class, EstudiantesView.class);

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
	}
}
