package frame;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileMenu (){
		super("File");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveAs = new JMenuItem("Save as");
		JMenuItem exit = new JMenuItem("Exit");
		//exit.addActionListener();//rendre le bouton exit fonctionnel
		
		this.add(open);
		this.addSeparator();
		this.add(save);
		this.add(saveAs);
		this.addSeparator();
		this.add(exit);
		
	}

}
