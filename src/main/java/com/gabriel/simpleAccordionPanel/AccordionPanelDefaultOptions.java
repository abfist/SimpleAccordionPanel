package com.gabriel.simpleAccordionPanel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccordionPanelDefaultOptions implements AccordionPanelOptions{

	private static final int NO_MAX = 0;
	private boolean _closedByDefault;
	private int _maxOpenHeight;
	private int _maxOpenWidth;
	private int _titleMaxWidth;
	private int _titleMaxSize;
	
	public AccordionPanelDefaultOptions()
	{
		set_closedByDefault(true);
		set_maxOpenHeight(NO_MAX);
		set_maxOpenWidth(NO_MAX);
		set_titleMaxSize(NO_MAX);
		set_titleMaxWidth(NO_MAX);
	}
	
	@Override
	public void config(AccordionPanel panel) {
		setViewMode(panel);
		//TODO handle max sizes
		
	}

	/**
	 * open the view if closed by default is false 
	 * close it otherwise
	 * @param panel 
	 */
	private void setViewMode(AccordionPanel panel) {
		if (is_closedByDefault())
		{
			panel.closePanel();	
		}
		else
		{
			panel.openPanel();
		}
	}

	@Override
	public void reset(AccordionPanel panel) {
		set_closedByDefault(true);
		set_maxOpenHeight(NO_MAX);
		set_maxOpenWidth(NO_MAX);
		set_titleMaxSize(NO_MAX);
		set_titleMaxWidth(NO_MAX);
		config(panel);
	}
	

}
