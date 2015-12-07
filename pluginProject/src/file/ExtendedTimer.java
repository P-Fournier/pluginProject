package file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ExtendedTimer implements ActionListener {
	protected ActionListener listener;	// listener which will call the action performed method
	protected Timer timer ;	// timer which will search plugin in a regular interval
	
	/**
	 * create an extended timer with the action listener past in parameter
	 * @param listener	the listener
	 */
	public ExtendedTimer (ActionListener listener){
		this.listener = listener ;
	}
	
	/**
	 * call the listener's actionPerformed method 
	 */
	public void actionPerformed (ActionEvent event){
		this.listener.actionPerformed(event);
	}
	
	/**
	 * start the timer (stop timer if it is already running)
	 */
	public void start(){
		if (timer != null){
			stop();
		}
		timer = new Timer(1000,this);
		timer.start();
	}
	
	/**
	 * stop the timer
	 */
	public void stop(){
		timer.stop();
		timer = null;
	}
}