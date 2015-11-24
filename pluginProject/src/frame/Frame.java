package frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;

	private JMenuBar menuBar;
	
	public Frame(){
		super();
		this.textArea = new JTextArea();
		this.menuBar = new JMenuBar();
		FileMenu fileMenu = new FileMenu();
		ToolsMenu toolsMenu = new ToolsMenu(this.textArea);
		
		menuBar.add(fileMenu);
		menuBar.add(toolsMenu);
	}

	
	
	// setters and getters
	
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


}
