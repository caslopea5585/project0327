package file;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileExplorer extends JFrame{
	
	JPanel panel;
	JLabel label;
	JButton bt;
	File file;
	ImageIcon icon;
	JButton[] button;
	Vector<JButton> jbt;
	Iterator<JButton> jbt_t;

	
	
	public FileExplorer() {

		
		
		file = new File("C:/");
		File[] dir = file.listFiles();
		jbt=new Vector<JButton>();
		
		for(int i=0; i<dir.length;i++){
			JPanel panel = new JPanel();
			JLabel label = new JLabel(dir[i].getName());
			
			
			ImageIcon icon = new ImageIcon("C:/java_workspace2/project0327/res/folder_off.png");
			 
			JButton bt = new JButton(icon);
			
			bt.setFocusPainted(false);
			bt.setOpaque(false);
			bt.setContentAreaFilled(false);
			bt.setBorderPainted(false);
			
					
			panel.setLayout(new BorderLayout());
			panel.add(label,BorderLayout.NORTH);
			panel.add(bt,BorderLayout.CENTER);
			
			add(panel);
			
		
			jbt.add(bt);
		
			jbt_t= jbt.iterator();
			System.out.println(jbt_t);
			System.out.println(jbt.size());
			
			
			bt.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
										
					for(int z=0; z<jbt.size();z++){
						jbt.get(z).setIcon(icon);
						
					}
					ImageIcon icon1 = new ImageIcon("C:/java_workspace2/project0327/res/folder_on.png");
					bt.setIcon(icon1);
					
				}
			});
			
			
		}
		

		
		setLayout(new FlowLayout());
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new FileExplorer();
	}

}
