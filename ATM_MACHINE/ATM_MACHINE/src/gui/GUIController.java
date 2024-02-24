package gui;
import java.awt.EventQueue;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import gui.modules.InputButtons;
import gui.modules.NumberPad;

//GUI Controller class
public class GUIController extends JFrame implements InputButtons{
	
	private static final long serialVersionUID = 1L;
	//timers for verification and loading screen
	Timer verifyTimer, loadMainTimer;
	public static JPanel centerDisplay;
	public static CreateWindow frame;
	
	//For Number Pad
	protected NumberPad numberPad = new NumberPad();
	
	//main funtion for project
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//creates new window
					frame = new CreateWindow();
					//makes visible 
					frame.setVisible(true);
				} catch (Exception e) {
					//if exception is thrown prints stack trace
					e.printStackTrace();
				}
			}
		});
	}
	
	///Action listeners for all buttons that call the overriden functions for each extended controller
	public GUIController() {
		//Numbered Buttons
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1();
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button2();
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button3();
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button4();
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button5();
			}
		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button6();
			}
		});
		
	}
	public void removeAll() {
		
		for( ActionListener al : btn1.getActionListeners() ) {
		        btn1.removeActionListener( al );
		}
		for( ActionListener al : btn2.getActionListeners() ) {
	        btn2.removeActionListener( al );
	}
		for( ActionListener al : btn3.getActionListeners() ) {
	        btn3.removeActionListener( al );
	}
		for( ActionListener al : btn4.getActionListeners() ) {
	        btn4.removeActionListener( al );
	}
		for( ActionListener al : btn5.getActionListeners() ) {
	        btn5.removeActionListener( al );
	}
		for( ActionListener al : btn6.getActionListeners() ) {
	        btn6.removeActionListener( al );
	}
	}
	public void refresh() {
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1();
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button2();
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button3();
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button4();
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button5();
			}
		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button6();
			}
		});
	
	}
	
	//general button functions
	public void button1() {
	
	}

	public void button2() {
		
	}

	public void button3() {
		
	}

	public void button4() {
		
	}

	public void button5() {
		
	}
	
	public void button6() {
		
	}
}
