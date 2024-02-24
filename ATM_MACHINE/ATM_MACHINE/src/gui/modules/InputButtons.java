package gui.modules;

import javax.swing.JButton;

//Input buttons interface that creats button on interface
public interface InputButtons {
	public static final JButton btn1 = new JButton("1");
	public static final JButton btn2 = new JButton("2");
	public static final JButton btn3 = new JButton("3");
	public static final JButton btn4 = new JButton("4");
	public static final JButton btn5 = new JButton("5");
	public static final JButton btn6 = new JButton("6");
	
	public abstract void button1();
	public abstract void button2();
	public abstract void button3();
	public abstract void button4();
	public abstract void button5();
	public abstract void button6();
}
