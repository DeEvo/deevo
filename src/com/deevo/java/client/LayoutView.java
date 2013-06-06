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
	@UiField HTMLPanel headContentPanel;
	@UiField HTMLPanel leftContentPanel;
	@UiField HTMLPanel footContentPanel;

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
 		else if (slot == LayoutPresenter.SLOT_SetLeftContent)
		{
			setLeftContent(content);
		}
 		else if (slot == LayoutPresenter.SLOT_SetHeadContent)
		{
			setHeadContent(content);
		}
 		else if (slot == LayoutPresenter.SLOT_SetFootContent)
		{
			setFootContent(content);
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
 
	private void setLeftContent(Widget content)
	{
		leftContentPanel.clear();
		if (content != null)
		{
			leftContentPanel.add(content);
		}		
	}
 
	private void setHeadContent(Widget content)
	{
		headContentPanel.clear();
		if (content != null)
		{
			headContentPanel.add(content);
		}		
	}

	private void setFootContent(Widget content)
	{
		footContentPanel.clear();
		if (content != null)
		{
			footContentPanel.add(content);
		}		
	}
	
}
