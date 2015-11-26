package file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ExtendedTimer implements ActionListener {
	protected ActionListener listener;
	protected Timer timer ;
	
	public ExtendedTimer (ActionListener listener){
		this.listener = listener ;
	}
	
	public void actionPerformed (ActionEvent event){
		this.listener.actionPerformed(event);
	}
	
	public void start(){
		if (timer != null){
			stop();
		}
		timer = new Timer(1000,this);
		timer.start();
	}
	
	public void stop(){
		timer.stop();
		timer = null;
	}
}
