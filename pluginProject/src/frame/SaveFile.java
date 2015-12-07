package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
/**
 * Class SaveFile, represent the action to save a file.
 * 
 * @author Paul
 * @author Nael
 * @author Quentin
 *
 */

public class SaveFile implements ActionListener {
	
	//attributes of the class Savefile
	private Frame frame; //frame associated to the save window dialog 
	private JTextArea textArea; //the text area that will be saved 
	
	/**
	 * Constructor SaveFile(Frame frame)
	 * @param frame : the frame associated to the save window dialog 
	 */
	public SaveFile(Frame frame){
		this.frame = frame;
		this.textArea = frame.getTextArea();
	}
	
	/**
	 * ChooseFile() : choose the file you will save in 
	 * @return the choosen file
	 */
	public File chooseFile(){
		JFileChooser overwriteFileWindow = new JFileChooser();
		overwriteFileWindow.showSaveDialog(frame);
		File file = overwriteFileWindow.getSelectedFile();
		
		return file;
	}
	
	/**
	 * method saveFile() : save the text of the text area to the choosen file
	 */
	public void saveFile(){
		try {
			File file = chooseFile();
			FileWriter fileWriter = new FileWriter(file);
			String text = textArea.getText();
			
			fileWriter.write(text);
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		saveFile();
	}

}
