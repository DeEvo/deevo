package com.deevo.java.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.deevo.java.client.place.ClientPlaceManager;
import com.deevo.java.client.IndexPresenter;
import com.deevo.java.client.IndexView;
import com.deevo.java.client.HeaderPresenter;
import com.deevo.java.client.HeaderView;
import com.deevo.java.client.FooterPresenter;
import com.deevo.java.client.FooterView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(IndexPresenter.class, IndexPresenter.MyView.class,
				IndexView.class, IndexPresenter.MyProxy.class);

		bindPresenter(HeaderPresenter.class, HeaderPresenter.MyView.class,
				HeaderView.class, HeaderPresenter.MyProxy.class);

		bindPresenter(FooterPresenter.class, FooterPresenter.MyView.class,
				FooterView.class, FooterPresenter.MyProxy.class);
	}
}
