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
import com.deevo.java.client.NuevoAlumnoPresenter;
import com.deevo.java.client.BusquedaAlumnoPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<HomePresenter> getHomePresenter();

	AsyncProvider<MainPresenter> getMainPresenter();

	AsyncProvider<LayoutPresenter> getRootPresenter();

	AsyncProvider<LayoutMainPresenter> getLayoutMainPresenter();

	AsyncProvider<NuevoAlumnoPresenter> getNuevoAlumnoPresenter();

	AsyncProvider<BusquedaAlumnoPresenter> getBusquedaAlumnoPresenter();

}
