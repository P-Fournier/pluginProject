package pluginProject;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter {
	
	protected String extension; //extension the filter will accept, in our case ".class"(?)
	
	public PluginFilter(String extension){
		this.extension = extension;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
