package com.deevo.java.client;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class RootPresenter extends
		Presenter<RootPresenter.MyView, RootPresenter.MyProxy> {

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetTopContent = new Type<RevealContentHandler<?>>();
	 
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetMainContent = new Type<RevealContentHandler<?>>();
 
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetSideContent = new Type<RevealContentHandler<?>>();
	
	FooterPresenter sideMenuPresenter;
	HeaderPresenter topMenuPresenter;
	
	public interface MyView extends View {
	}

	@ProxyCodeSplit
	public interface MyProxy extends Proxy<RootPresenter> {
	}

	@Inject
	public RootPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();

		// Load the top menu bar
		setInSlot(SLOT_SetTopContent, topMenuPresenter);
 
		// Load the profile side view
		setInSlot(SLOT_SetSideContent, sideMenuPresenter);
	}
	
	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
}
