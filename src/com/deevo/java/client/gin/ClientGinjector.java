package com.deevo.java.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.deevo.java.client.gin.ClientModule;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.gwt.inject.client.AsyncProvider;
import com.deevo.java.client.IndexPresenter;
import com.deevo.java.client.HeaderPresenter;
import com.deevo.java.client.FooterPresenter;
import com.deevo.java.client.PanelPresenter;
import com.deevo.java.client.EstudiantesPresenter;
import com.deevo.java.client.BodyPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<IndexPresenter> getIndexPresenter();

	AsyncProvider<HeaderPresenter> getHeaderPresenter();

	AsyncProvider<FooterPresenter> getFooterPresenter();

	AsyncProvider<PanelPresenter> getPanelPresenter();

	AsyncProvider<EstudiantesPresenter> getEstudiantesPresenter();

	AsyncProvider<BodyPresenter> getBodyPresenter();

}
