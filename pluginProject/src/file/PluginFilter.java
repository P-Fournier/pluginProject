package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;

import plugins.*;

public class PluginFilter implements FilenameFilter {
	
	/**
	 * create a new plugin filter
	 */
	public PluginFilter(){	}
	
	@Override
	public boolean accept(File dir, String name) {
		boolean accept = true;
		// test if the file is class file
		if( name.endsWith(".class")){
			// create a file in the bin repository corresponding to the '.class'
			File copy = copy(name);
			Class<?> theClass = this.getClass(name);
			//test if the class has been created with success
			if (theClass==null){
				accept = false;
			}else{
				// test if the class implements the Plugin interface
				if (!Plugin.class.isAssignableFrom(theClass)){
					accept = false;
				}
				// test if the class is in the plugins package
				if (!theClass.getPackage().getName().equals("plugins")){
					accept = false;
				}
				// test if the class get an empty constructor
				if (!hadAnEmptyConstructor(theClass)){
					accept = false;
				}
			}	
			if (!accept){
				// if the plugin isn't accept , the copy is deleted
				copy.delete();
			}
		}else{
			accept = false;
		}
		
		return accept ;
	}
	
	/**
	 * copy the file corresponding to the name past in parameter in the bin repository
	 * @param name the file's name 
	 * @return the file which is the copy
	 */
	public File copy (String name ){
		File source = new File ("./dropins/"+name);
		File destination = new File ("./bin/plugins/"+name);
		try {
			destination.createNewFile();
			FileInputStream input = new FileInputStream (source);
			FileOutputStream output = new FileOutputStream (destination);
			byte buffer[]=new byte[512*1024];
	        int nblecture;
	        while((nblecture=input.read(buffer))!=-1){
	              output.write(buffer,0,nblecture);
	        }
	        input.close();
	        output.close();
	        return destination;
		} catch (IOException e) {
			throw new RuntimeException ("problem of file");
		}
		
	}
	
	/**
	 * return instance of the class corresponding to the file name past in parameter
	 * @param name class's name
	 * @return instance of the class
	 */
	public Class<?> getClass(String name){
		try {
			return Class.forName("plugins."+name.replaceFirst("\\.class$", ""));
			
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	/**
	 * test if the class past in parameter get an empty constructor
	 * @param theClass the class tested
	 * @return true if it had an empty constructor
	 */
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
