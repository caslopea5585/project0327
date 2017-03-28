package homework;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountApp extends JFrame {

	
	JLabel lv,rv;
	Left_Thread lt;
	Right_Thread rt;
	CountApp countapp;
	
	public CountApp() {
		
		lv=new JLabel();
		rv=new JLabel();
		
		lt=new Left_Thread(this);
		rt=new Right_Thread(this);
		
		
		add(lv,BorderLayout.WEST);
		add(rv,BorderLayout.EAST);
		
		lt.start();
		rt.start();
		
		//mylabel is a Jlabel // my_thread is a mylabel
		
	
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
	}
	
	public static void main(String[] args) {
		new CountApp();

	}

}
