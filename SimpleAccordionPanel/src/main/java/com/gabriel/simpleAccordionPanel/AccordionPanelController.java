package com.gabriel.simpleAccordionPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AccordionPanelController {

	public static MouseListener getMouseListener(AccordionPanel panel) {
		// TODO Auto-generated method stub
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (panel.is_panelClosed())
				{
					panel.openPanel();
				}
				else
				{
					panel.closePanel();
				}
				super.mouseClicked(e);
			}
			
		};
	}

}
