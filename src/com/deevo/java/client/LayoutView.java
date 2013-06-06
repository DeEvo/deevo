package com.deevo.java.client;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class LayoutView extends ViewImpl implements LayoutPresenter.MyView {

	private final Widget widget;
	
	@UiField HTMLPanel mainContentPanel;
	@UiField HTMLPanel sideContentPanel;
	@UiField HTMLPanel topContentPanel;

	public interface Binder extends UiBinder<Widget, LayoutView> {
	}

	@Inject
	public LayoutView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == LayoutPresenter.SLOT_SetMainContent)
		{			
			setMainContent(content);
		}
 		else if (slot == LayoutPresenter.SLOT_SetSideContent)
		{
			setSideContent(content);
		}
 		else if (slot == LayoutPresenter.SLOT_SetTopContent)
		{
			setTopContent(content);
		}
 		else
		{
			super.setInSlot(slot, content);
		}
	}
	
	private void setMainContent(Widget content) 
	{
	    mainContentPanel.clear();
	    if (content != null) 
	    {
	      mainContentPanel.add(content);
	    }
	}
 
	private void setSideContent(Widget content)
	{
		sideContentPanel.clear();
		if (content != null)
		{
			sideContentPanel.add(content);
		}		
	}
 
	private void setTopContent(Widget content)
	{
		topContentPanel.clear();
		if (content != null)
		{
			topContentPanel.add(content);
		}		
	}
	
}
