package frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected JTextArea textArea = new JTextArea();
	private JMenuBar menuBar = new JMenuBar();
	private ToolsMenu toolsMenu;
	
	
	public Frame(){
		this.setTitle("pluginProject");
		this.setSize(400,300);
		this.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPan = new JScrollPane(this.textArea);
	
		FileMenu fileMenu = new FileMenu(this);
		setToolsMenu(new ToolsMenu(this.textArea));
		
		
		this.menuBar.add(fileMenu);
		this.menuBar.add(getToolsMenu());
		this.setJMenuBar(menuBar);
		this.add(scrollPan);
		
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



	public ToolsMenu getToolsMenu() {
		return toolsMenu;
	}



	public void setToolsMenu(ToolsMenu toolsMenu) {
		this.toolsMenu = toolsMenu;
	}


}
