package file;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

import plugins.*;

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
		System.out.println(name);
		if( name.endsWith(".class")){
			Class<?> theClass = this.getClass(name);
			if (theClass==null){
				return false;
			}
			// on test si la class implémente plugin
			if (!Plugin.class.isAssignableFrom(theClass)){
				System.out.println("implements");
				return false;
			}
			// on test si la class appartient au package plugins
			if (!theClass.getPackage().getName().equals("plugins")){
				System.out.println("package");
				return false;
			}
			// on test si la class a un constructeur vide 
			if (!hadAnEmptyConstructor(theClass)){
				System.out.println("constructeur");
				return false;
			}
			System.out.println("ok");
			return true;
		}
		return false;
	}
	
	public Class<?> getClass(String name){
		try {
			return Class.forName("plugins".replaceFirst("\\.class$", ""));
			
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	public boolean hadAnEmptyConstructor(Class<?> theClass){
		Constructor<?>[] constructors = theClass.getConstructors();
		for (int i=0 ; i<constructors.length ;i++){
			if (constructors[i].getParameterTypes().length==0){
				return true;
			}
		}
		return false;
	}
	
	

}
