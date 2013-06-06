package com.deevo.java.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.deevo.java.client.place.ClientPlaceManager;
import com.deevo.java.client.place.DefaultPlace;
import com.deevo.java.client.place.NameTokens;
import com.deevo.java.client.BodyPresenter;
import com.deevo.java.client.BodyView;
import com.deevo.java.client.IndexPresenter;
import com.deevo.java.client.IndexView;
import com.deevo.java.client.LoginPresenter;
import com.deevo.java.client.LoginView;
import com.deevo.java.client.PanelPresenter;
import com.deevo.java.client.PanelView;
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
import com.deevo.java.client.LayoutPanelPresenter;
import com.deevo.java.client.LayoutPanelView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.index);

		bindPresenter(IndexPresenter.class, IndexPresenter.MyView.class,
				IndexView.class, IndexPresenter.MyProxy.class);

		bindPresenter(PanelPresenter.class, PanelPresenter.MyView.class,
				PanelView.class, PanelPresenter.MyProxy.class);

		bindPresenter(LayoutPresenter.class, LayoutPresenter.MyView.class,
				LayoutView.class, LayoutPresenter.MyProxy.class);
		
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

		bindPresenter(LayoutPanelPresenter.class,
				LayoutPanelPresenter.MyView.class, LayoutPanelView.class,
				LayoutPanelPresenter.MyProxy.class);
	
	}
}
