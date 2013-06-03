package com.deevo.java.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.deevo.java.client.place.ClientPlaceManager;
import com.deevo.java.client.IndexPresenter;
import com.deevo.java.client.IndexView;
import com.deevo.java.client.place.DefaultPlace;
import com.deevo.java.client.place.NameTokens;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));


		bindPresenter(IndexPresenter.class, IndexPresenter.MyView.class,
				IndexView.class, IndexPresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.index);
	}
}
