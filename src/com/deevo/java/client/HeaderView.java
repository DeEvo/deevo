package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class HeaderView extends ViewImpl implements HeaderPresenter.MyView {

	private final Widget widget;
	
	@UiField HTMLPanel contentPanel;
	
	public interface Binder extends UiBinder<Widget, HeaderView> {
	}

	@Inject
	public HeaderView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	public void setInSlot(Object slot, Widget Content){
		if(slot == HeaderPresenter.SLOT_content){
			contentPanel.clear();
			if(Content!= null){
			contentPanel.add(Content);
			}
		}else{
			super.setInSlot(slot,Content);
		}
	}
}
