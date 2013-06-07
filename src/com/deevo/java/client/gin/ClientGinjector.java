package com.deevo.java.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.deevo.java.client.gin.ClientModule;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.gwt.inject.client.AsyncProvider;
import com.deevo.java.client.IndexPresenter;
import com.deevo.java.client.PanelPresenter;
import com.deevo.java.client.LayoutPresenter;
import com.deevo.java.client.LayoutPanelPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<IndexPresenter> getIndexPresenter();

	AsyncProvider<PanelPresenter> getPanelPresenter();

	AsyncProvider<LayoutPresenter> getRootPresenter();

	AsyncProvider<LayoutPanelPresenter> getLayoutPanelPresenter();

}
