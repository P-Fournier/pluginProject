package pluginProject;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public class PluginFinder {
	
	protected String directory; // directory where the finder search plugin
	protected PluginFilter filter = new PluginFilter () ;
	
	/**
	 * create a plugin finder to search in the directory past in parameter
	 * @param directory search plugin in this directory
	 */
	public PluginFinder (String directory){
		this.directory=directory;
	}
	
	/**
	 * return all the files in the directory
	 * @return all the directory's files
	 */
	public List<File> getAllFiles(){
		File dir = new File (this.directory);
		File[] files = dir.listFiles(filter);
		if (files == null || files.length==0){
			return new ArrayList<File> ();
		}
		return new ArrayList<File>(Arrays.asList(files));
	}
}
