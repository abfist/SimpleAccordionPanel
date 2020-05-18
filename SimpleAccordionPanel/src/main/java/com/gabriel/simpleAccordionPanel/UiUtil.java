package com.gabriel.simpleAccordionPanel;

import java.awt.Adjustable;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class UiUtil {
	
	
	public static Dimension getScreenSize()
	{
		return Toolkit.getDefaultToolkit().getScreenSize();
	}


	public static double getScreenHeight()
	{
		return Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	}

	public static double getScreenWidth()
	{
		return Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	}
	
	/**
	 * return precent of screen height
	 * @param precent - the precent presented as a number between 0-1
	 * @return the number of pixels
	 */
	public static double getPrecentOfScreenHeight(float precent)
	{
		return Toolkit.getDefaultToolkit().getScreenSize().getHeight()*precent;
	}

	/**
	 * return precent of screen width
	 * @param precent - the precent presented as a number between 0-1
	 * @return the number of pixels
	 */
	public static double getPrecentOfScreenWidth(float precent)
	{
		return Toolkit.getDefaultToolkit().getScreenSize().getWidth()*precent;
	}
	

	/**
	 * turn a text containing new lines to an html containing <br> elements 
	 * in order to show it in a jlabel 
	 * @param originalText
	 * @return
	 */
	public static String transfromNewLinesToBr(String originalText)
	{
		String newText = originalText.replaceAll("\n", "<br>");
		StringBuilder builder=new StringBuilder();
		builder.append("<html><body>");
		builder.append(newText);
		builder.append("</body></html>");
		return builder.toString();

	}

	public static ImageIcon resizeImage(ImageIcon original,int newHeigh,int newWidth)
	{
		Image image = original.getImage(); // transform it 
		Image newimg = image.getScaledInstance(newWidth, newHeigh,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ImageIcon imageIcon = new ImageIcon(newimg);  // transform it back
		return imageIcon;
	}

	/**
	 * when the scroll area is changing and adds a vertical scrollbar scroll to the bottom
	 * but allow scrolling up later 
	 * @param scrollPane
	 */
	public static void  scrollToBottom(JScrollPane scrollPane) 
	{
		JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
		verticalBar.setValue( verticalBar.getMaximum());

		AdjustmentListener downScroller = new AdjustmentListener() 
		{
			private int lastValue=0;
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {	        	
				Adjustable adjustable = e.getAdjustable();
				if (adjustable.getMaximum()!=lastValue)
				{
					adjustable.setValue(adjustable.getMaximum());
					this.lastValue=adjustable.getMaximum();
				}
				
			}
		};

		verticalBar.addAdjustmentListener(downScroller);
	}
	
	
	
}
