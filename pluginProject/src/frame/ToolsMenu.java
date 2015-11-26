package frame;

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
		JMenuItem plug = new JMenuItem("toLowerCase");

		this.add(plug);
	}
	
	public void transformTextArea(Plugin plugin){
	 this.textArea.setText((plugin).transform(this.textArea.getText()));
	}
	
	

}
