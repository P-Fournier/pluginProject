package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/*
 * Class FileMenu which represent the File tag in menu bar of the frame
 */

public class FileMenu extends JMenu {

	private static final long serialVersionUID = -4879681865933074476L;

	/**
	 * Constructor FileMenu(Frame frame)
	 * @param Frame frame 
	 */
	public FileMenu (Frame frame){
		super("File");
		
		//initialisation of the items which compose the menu File
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		
		//add action to the item to make them functional
		save.addActionListener(new SaveFile(frame));
		open.addActionListener(new OpenFile(frame));
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}
		});
		
		//start adding the items to the file menu
		this.add(open);
		this.addSeparator();
		this.add(save);
		this.addSeparator();
		this.add(exit);
		
	}

}
