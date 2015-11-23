package file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class PluginFilter implements FilenameFilter {
	
	protected String extension; //extension the filter will accept, in our case ".class"(?)
	protected List<File> conformFiles;
	
	
	public PluginFilter(String extension){
		this.extension = extension;
		this.conformFiles = new ArrayList<File>();
	}
	
	//A VERIFIER SI J'AI BIEN COMPRIS L'UTILITE DE CETTE CLASSE
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}
	
	public void addFile(File file){
		File dir = new File(".");
		if (this.accept(dir, file.getName())) {
			this.conformFiles.add(file);
		}
	}
	
	

}
