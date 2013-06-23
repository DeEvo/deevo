package com.deevo.java.client;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;

public class BandejaAlertaPresenter
		extends
		Presenter<BandejaAlertaPresenter.MyView, BandejaAlertaPresenter.MyProxy> {

	public interface MyView extends View {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.bandejaalerta)
	public interface MyProxy extends ProxyPlace<BandejaAlertaPresenter> {
	}

	@Inject
	public BandejaAlertaPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutMainPresenter.SLOT_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
}
