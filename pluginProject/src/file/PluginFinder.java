package file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import frame.ToolsMenu;
import plugins.Plugin;

public class PluginFinder implements ActionListener {
	
	protected ExtendedTimer finderListener;  // timer which execute action for a regular interval
	protected String directory; // directory where the finder search plugin
	protected PluginFilter filter = new PluginFilter () ;  // filter which only keep valid plugin
	protected List<File> plugins;  // list of files containing plugins which are in the tools menu
	private ToolsMenu toolsMenu; // tools menu which contains plugins
	
	
	/**
	 * create a plugin finder to search in the directory past in parameter
	 * @param directory search plugin in this directory
	 * @param toolsMenu add plugin in this ToolsMenu
	 */
	public PluginFinder (String directory, ToolsMenu toolsMenu){
		this.directory=directory;
		this.toolsMenu = toolsMenu;
		this.plugins = new ArrayList<File>();
		this.finderListener = new ExtendedTimer(this);
		finderListener.start();
	}
	
	/**
	 * return all the files in the directory
	 * @return all the directory's files
	 */
	public ArrayList<File> getAllFiles(){
		File dir = new File (this.directory);
		File[] files = dir.listFiles(filter);
		if (files == null || files.length==0){
			return new ArrayList<File> ();
		}
		return new ArrayList<File>(Arrays.asList(files));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<File> allFiles = this.getAllFiles();
		if(!(this.plugins.equals(allFiles))){
			this.notify(allFiles);
			this.plugins = allFiles ;
		}
		
	}
	
	/**
	 * convert the file list into plugins list
	 * @param files the list of files converted
	 * @return the list of plugins
	 */
	public ArrayList<Plugin> castFileToPlugin(ArrayList<File> files){
		ArrayList<Plugin> plugs = new ArrayList<Plugin>();
		for( File f : files){
			Class<?>theClass = filter.getClass(f.getName());
			if (theClass == null){
				
			}else{
				try{
					plugs.add((Plugin)theClass.newInstance());
				}catch(IllegalAccessException | InstantiationException e){
					System.out.println("this file isn't a plugin");
				}
			}
			
		}
		return plugs;
	}
	
	/**
	 * send a message to the tools menu containing the new list files
	 * for updating it
	 * @param allFiles the files's list send to the tools menu
	 */
	private void notify(ArrayList<File> allFiles) {
		
		this.toolsMenu.update(this.castFileToPlugin(allFiles));
	}
}
