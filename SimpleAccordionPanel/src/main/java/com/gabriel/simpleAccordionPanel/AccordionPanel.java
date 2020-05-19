package com.gabriel.simpleAccordionPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import lombok.Data;
import net.miginfocom.swing.MigLayout;

/**
 * A panel that expands and shrinks when pressed - when shrunk shows the title
 * when expanded it shows an inner pannel
 * 
 * usage:
 * provide a content Jpanel, a title, and open and closed iconset (optional) 
 * @author abfist
 *
 */
@Data
public class AccordionPanel extends JPanel {
	
	private IconSet _iconset;
	private JPanel _contentPanel;
	private String _title;
	private JLabel _titleLabel;
	private JPanel _titlePanel;
	private JLabel _iconLabel;
	private AccordionPanelOptions _options;	
	private boolean _panelClosed;
		
	public AccordionPanel(String title, JPanel contentPanel) 
	{
		this(title, contentPanel,null);
	}
	
	public AccordionPanel(String title, JPanel contentPanel,AccordionPanelOptions options) 
	{
		this(title, contentPanel,options,null);
	}
	
	public AccordionPanel(String title, JPanel contentPanel,AccordionPanelOptions options,IconSet iconSet) 
	{
		super();
		setLayout(new MigLayout());
		set_title(title);
		set_contentPanel(contentPanel);
		set_options(options);
		set_iconset(iconSet);
		set_titleLabel(new JLabel());
		set_iconLabel(new JLabel());
		
		initTitlePanel();
		init();
	}


	private void initTitlePanel() {
		set_titlePanel(new JPanel(new MigLayout()));
		_titlePanel.add(_titleLabel);
		_titlePanel.add(_iconLabel);
		_titlePanel.addMouseListener(AccordionPanelController.getMouseListener(this));
	}
	
	
	public void init()
	{
		checkVariables();
		initGui();
		
	}

	/**
	 * test that all the variables are set correctly initialize default values for missing iconset or missing options
	 */
	private void checkVariables() {
		if (get_title()==null||get_contentPanel()==null)
		{
			throw new IllegalArgumentException("title or content missing, title is:"+get_title()+
					" content is:"+get_contentPanel());
		}
		if (get_iconset()==null)
		{
			set_iconset(IconSet.getDefaultIconSet());
		}
		if (get_options()==null)
		{
			AccordionPanelOptions options =new AccordionPanelDefaultOptions();
			set_options(options);
		}
	}

	private void initGui() {
		get_titleLabel().setText(get_title());
		get_options().config(this);
	}


	/**
	 * show only the title and the closed icon
	 */
	public void closePanel() {
		this.removeAll();
		
		get_iconLabel().setIcon(get_iconset().get_closedIcon());

		this.add(get_titlePanel());
		
		set_panelClosed(true);
		refreshFrame();
	}
	
	

	/**
	 * show only the title and the closed icon
	 */
	public void openPanel() {
		this.removeAll();
		
		get_iconLabel().setIcon(get_iconset().get_openIcon());

		this.add(get_titlePanel(),"wrap");
		this.add(get_contentPanel(),"wrap");
		set_panelClosed(false);
		refreshFrame();
	}
	
	public void refreshFrame()
	{
		if (SwingUtilities.getRoot(this)!=null)
		{
			SwingUtilities.updateComponentTreeUI(SwingUtilities.getRoot(this));	
		}
	}
}
