package com.gabriel.simpleAccordionPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import lombok.Data;

@Data
public class IconSet {
	private static final String DEFAULT_OPEN_ICON = "Arrow-Down-1024px.png";
	private static final String DEFAULT_CLOSED_ICON = "Arrow-Right-1024px.png";
	private ImageIcon _openIcon;
	private ImageIcon _closedIcon;


	public IconSet()
	{
		createDefaultIconSet();
	}
	
	public IconSet(String openIconPath,String closedIconPath)
	{
		BufferedImage openIconImage = null;
		BufferedImage closedIconImage = null;
		try {
			openIconImage = ImageIO.read(new File(openIconPath));
			closedIconImage = ImageIO.read(new File(closedIconPath));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (openIconImage==null||closedIconImage==null)
		{
			createDefaultIconSet();
		}
		else 
		{
			_openIcon=new ImageIcon(openIconImage);
			_closedIcon=new ImageIcon(closedIconImage);
		}
	}


	public IconSet(ImageIcon openIcon,ImageIcon closedIcon)
	{
		_openIcon=openIcon;
		_closedIcon=closedIcon;
	}

	public IconSet(ImageIcon openIcon,ImageIcon closedIcon,int height,int width)
	{
		_openIcon=openIcon;
		_closedIcon=closedIcon;
		resize(height, width);
	}

	public void resize(int height,int width)
	{
		_openIcon=UiUtil.resizeImage(_openIcon, height, width);
		_closedIcon=UiUtil.resizeImage(_closedIcon, height, width);
	}

	private void createDefaultIconSet() 
	{		
		BufferedImage openIconImage = null;
		BufferedImage closedIconImage = null;
		try 
		{
			
			openIconImage = ImageIO.read(IconSet.class.getClassLoader().getResourceAsStream(DEFAULT_OPEN_ICON));
			closedIconImage = ImageIO.read(IconSet.class.getClassLoader().getResourceAsStream(DEFAULT_CLOSED_ICON));
			_openIcon=new ImageIcon(openIconImage);
			_closedIcon=new ImageIcon(closedIconImage);
			resize(20, 20);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static IconSet getDefaultIconSet() {
		return new IconSet();	
	}
}

