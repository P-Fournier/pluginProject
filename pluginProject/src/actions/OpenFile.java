package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import frame.Frame;

public class OpenFile implements ActionListener {
	
	private JTextArea textArea;
	private Frame frame;

	public OpenFile(Frame frame){
		this.textArea = frame.getTextArea();
		this.frame = frame;
	}
	
	
	public File chooseFile(){
		JFileChooser chooseFileWindow = new JFileChooser();
		chooseFileWindow.showOpenDialog(frame);
		File file = chooseFileWindow.getSelectedFile();
		
		return file;
	}
	
	public void loadFile(){
		File fichier = chooseFile();
		
		try {
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
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		loadFile();
	}
}
