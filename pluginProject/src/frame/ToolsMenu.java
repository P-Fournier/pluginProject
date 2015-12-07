package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import plugins.Plugin;

/**
 * Class ToolsMenu that represent the tag Tools of the frame 
 * @author Paul
 * @author Nael
 * @author Quentin
 *
 */

public class ToolsMenu extends JMenu {
	
	private static final long serialVersionUID = -7930071014277568619L;
	
	//attribute of the class ToolsMenu
	protected JTextArea textArea; //the text area the effects will be applied
	
	/**
	 * Constructor toolsMenu(JTextArea textArea)
	 * @param textArea 
	 */
	public ToolsMenu(JTextArea textArea){
		super("Tools");
		this.textArea=textArea;
	}
	
	/**
	 * method transformTextArea(Plugin plugin) : use the method transform(String s) of the plugin in parameter
	 * @param plugin the plugin will apply his transform method
	 */
	public void transformTextArea(Plugin plugin){
	 this.textArea.setText(plugin.transform(this.textArea.getText()));
	}
	
	/**
	 * method update will update the list of items of the tools menu with the list of plugins found by the finder
	 * @param finderPlugins
	 */
	public void update(ArrayList<Plugin> finderPlugins) {
		this.removeAll();
		for ( Plugin p : finderPlugins){
			final Plugin plugAdd = p ;
			JMenuItem plug = new JMenuItem(p.getLabel());
			plug.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						transformTextArea(plugAdd);
					}
				});
			this.add(plug);
		}
	}
	
	

}
