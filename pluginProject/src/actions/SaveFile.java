package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import frame.Frame;

public class SaveFile implements ActionListener {
	
	private Frame frame;
	private JTextArea textArea;
	
	public SaveFile(Frame frame){
		this.frame = frame;
		this.textArea = frame.getTextArea();
	}
	
	
	public File chooseFile(){
		JFileChooser overwriteFileWindow = new JFileChooser();
		overwriteFileWindow.showSaveDialog(frame);
		File file = overwriteFileWindow.getSelectedFile();
		
		return file;
	}
	
	public void saveFile(){
		File file = chooseFile();
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			String text = textArea.getText();
			
			fileWriter.write(text);
			fileWriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		saveFile();
	}

}
