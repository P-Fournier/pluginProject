package file;

import java.io.File;
import java.util.List;

import frame.Frame;

public class Main {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Frame frameTest = new Frame();
		PluginFinder finder = new PluginFinder("./dropins",frameTest.getToolsMenu());
		List<File> files =finder.getAllFiles();
//		for (File f : files){
//			
//			Class plugClass = getClass(f.getName());
//			Plugin plug = (Plugin) f;
//			System.out.println(plug.getLabel());
//		}
	}

}
