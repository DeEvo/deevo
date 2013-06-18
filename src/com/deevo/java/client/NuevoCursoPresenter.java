package com.deevo.java.client;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.deevo.java.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class NuevoCursoPresenter extends
		Presenter<NuevoCursoPresenter.MyView, NuevoCursoPresenter.MyProxy> {

	public interface MyView extends View {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.nuevocurso)
	public interface MyProxy extends ProxyPlace<NuevoCursoPresenter> {
	}

	@Inject
	public NuevoCursoPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	protected void onReset() {
		super.onReset();
	}
}
