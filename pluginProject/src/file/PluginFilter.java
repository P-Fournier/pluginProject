package file;

import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;

/*
 * le but de cette classe ca va etre de vérifier que les fichiers trouvés sont des plugins
 */
public class PluginFilter implements FilenameFilter {
	
	//protected String extension; //extension the filter will accept, in our case ".class"(?)
	// je ne suis pas sur de l'utilité de extension puisque ce sera toujours ".class" mais ca 
	// se discute 
	//protected List<File> conformFiles;
	
	
	public PluginFilter(/*String extension*/){
		//this.extension = extension;
		//this.conformFiles = new ArrayList<File>();
	}
	
	//A VERIFIER SI J'AI BIEN COMPRIS L'UTILITE DE CETTE CLASSE
	@Override
	public boolean accept(File dir, String name) {
		
		if( name.endsWith(".class")){
			try{
				Class<?> theClass = Class.forName(name.replaceFirst("\\.class$",""));
				// on test si la class implémente plugin
				if (!Plugin.class.isAssignableFrom(theClass)){
					return false;
				}
				// on test si la class appartient au package plugins
				if (!theClass.getPackage().getImplementationTitle().equals("plugins")){
					return false;
				}
				// on test si la class a un constructeur vide 
				if (theClass.getConstructors().length==0){
					return false;
				}
			}catch(ClassNotFoundException e){
				return false ;
			}
			return true;
		}
		return false;
	}
	
	/*public void addFile(File file){
		File dir = new File(".");
		if (this.accept(dir, file.getName())) {
			this.conformFiles.add(file);
		}
	}*/
	
	

}
