package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import file.PluginFinder;
import plugins.Plugin;

/*
 * Onglet TOOLS de la frame, avec la liste des plugins
 */

public class ToolsMenu extends JMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected JTextArea textArea;
	private int i;
	
	public ToolsMenu(JTextArea textArea){
		super("Tools");
		this.textArea=textArea;
		PluginFinder finder = new PluginFinder(".");
		
		ArrayList<File> plugList = finder.getAllFiles();
		for ( i = 0; i < plugList.size(); i++) {
			JMenuItem plug = new JMenuItem(((Plugin) plugList.get(i)).getLabel());
			plug.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					transformTextArea((Plugin) plugList.get(i));
				}
			});
			this.add(plug);
		}
	}
	
	public void transformTextArea(Plugin plugin){
	 this.textArea.setText((plugin).transform(this.textArea.getText()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
