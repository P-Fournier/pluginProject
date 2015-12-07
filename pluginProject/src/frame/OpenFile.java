package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class OpenFile implements ActionListener {
	
	//attributes of the class OpenFile
	protected JTextArea textArea; //text area where the file will be open 
	protected Frame frame; //frame associated to the dialog window
	
	/**
	 * Constructor OpenFile(Frame frame)
	 * @param frame : the frame associated 
	 */
	public OpenFile(Frame frame){
		this.textArea = frame.getTextArea();
		this.frame = frame;
	}
	
	/**
	 * method chooseFile()
	 * @return the choosen file (File)
	 */
	public File chooseFile(){
		JFileChooser chooseFileWindow = new JFileChooser();
		chooseFileWindow.showOpenDialog(frame);
		File file = chooseFileWindow.getSelectedFile();
		
		return file;
	}
	
	/**
	 * method loadFile() , load to the text area the File you chose in the dialog window 
	 */
	public void loadFile(){
		
		
		try {
			File fichier = chooseFile();
			FileReader fileReader = new FileReader(fichier);
			@SuppressWarnings("resource")
			BufferedReader bufReader = new BufferedReader(fileReader);
			
			//Empty the text area
			textArea.setText("");
			
			// Start reading the file 
			String line;
			while((line= bufReader.readLine()) != null)
			{
				textArea.append(line);
				textArea.append("\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		loadFile();
	}
}
