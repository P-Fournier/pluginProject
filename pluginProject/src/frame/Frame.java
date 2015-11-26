package frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea = new JTextArea();

	private JMenuBar menuBar = new JMenuBar();
	
	
	public Frame(){
		this.setTitle("pluginProject");
		this.setSize(400,300);
		this.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	
		FileMenu fileMenu = new FileMenu();
		ToolsMenu toolsMenu = new ToolsMenu(this.textArea);
		
		
		this.menuBar.add(fileMenu);
		this.menuBar.add(toolsMenu);
		this.setJMenuBar(menuBar);
		this.add(textArea);
		
		this.setVisible(true);
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
