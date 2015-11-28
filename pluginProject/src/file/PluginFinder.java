package file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import plugins.Plugin;

public class PluginFinder implements ActionListener {
	
	protected ExtendedTimer finderListener;
	protected String directory; // directory where the finder search plugin
	protected PluginFilter filter = new PluginFilter (/*".class"*/) ;
	protected List<File> plugins;
	
	/**
	 * create a plugin finder to search in the directory past in parameter
	 * @param directory search plugin in this directory
	 */
	public PluginFinder (String directory){
		this.directory=directory;
		this.plugins = new ArrayList<File>();
		this.finderListener = new ExtendedTimer(this);
		//finderListener.start();
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
		List<File> allFiles = this.getAllFiles();
		if(!(this.plugins.equals(allFiles))){
			this.notify(allFiles);
		}
		
	}
	
	public ArrayList<Plugin> castFileToPlugin(ArrayList<File> files){
		ArrayList<Plugin> plugs = new ArrayList<Plugin>();
		
		
		return plugs;
	}

	private void notify(List<File> allFiles) {
		// TODO Auto-generated method stub
		
	}
}
