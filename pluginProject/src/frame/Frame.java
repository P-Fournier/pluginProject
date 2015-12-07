package frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import file.PluginFinder;

/**
 *The frame of the project 
 *
 */
public class Frame extends JFrame {

	
	private static final long serialVersionUID = -1246921358455431337L;
	
	
	//attributes of the class Frame
	protected JTextArea textArea = new JTextArea(); //text area of the frame
	protected JMenuBar menuBar = new JMenuBar(); //menu bar of the frame
	protected ToolsMenu toolsMenu; //Menu that will interact with the text area
	protected PluginFinder finder ; // finder will find the files
	
	/**
	 * Constructor Frame(directory)
	 * @param String directory : name of the path to the directory
	 */
	public Frame(String directory){
		this.setTitle("pluginProject");
		this.setSize(400,300);
		this.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//make the text area scrollable
		JScrollPane scrollPan = new JScrollPane(this.textArea);
		
		//initialisation of the tags of the frame (File,Tools)
		FileMenu fileMenu = new FileMenu(this);
		this.toolsMenu=new ToolsMenu(this.textArea);
		
		
		//add the tags to the menu bar
		this.menuBar.add(fileMenu);
		this.menuBar.add(this.toolsMenu);
		
		this.setJMenuBar(menuBar);
		this.add(scrollPan);
		
		this.finder= new PluginFinder (directory,this.toolsMenu);
	}

	
	
	// begin setters and getters
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


	public JMenuBar getMenuBarP() {
		return menuBar;
	}


	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}


	public ToolsMenu getToolsMenu() {
		return toolsMenu;
	}


	public void setToolsMenu(ToolsMenu toolsMenu) {
		this.toolsMenu = toolsMenu;
	}
	
	// end setters and getters

}
