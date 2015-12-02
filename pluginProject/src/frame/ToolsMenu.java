package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import plugins.Plugin;

/*
 * Onglet TOOLS de la frame, avec la liste des plugins
 */

public class ToolsMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected JTextArea textArea;
	
	public ToolsMenu(JTextArea textArea){
		super("Tools");
		this.textArea=textArea;
	}
	
	public void transformTextArea(Plugin plugin){
	 this.textArea.setText(plugin.transform(this.textArea.getText()));
	}

	public void update(ArrayList<Plugin> finderPlugins) {
		this.removeAll();
		for ( Plugin p : finderPlugins){
			JMenuItem plug = new JMenuItem(p.getLabel());
			plug.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						transformTextArea(p);
					}
				});
			this.add(plug);
		}
	}
	
	

}
