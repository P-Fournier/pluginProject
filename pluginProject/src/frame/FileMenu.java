package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import actions.OpenFile;
import actions.SaveFile;

public class FileMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileMenu (Frame frame){
		super("File");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		save.addActionListener(new SaveFile(frame));
		open.addActionListener(new OpenFile(frame));
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}
		});
		//exit.addActionListener();//rendre le bouton exit fonctionnel
		
		this.add(open);
		this.addSeparator();
		this.add(save);
		this.addSeparator();
		this.add(exit);
		
	}

}
