package homework3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class FileCopy extends JFrame implements ActionListener{
	FileCopy filecopy;
	JProgressBar bar;
	JButton ori_open, dest_open, copy;
	JTextField ori_path, dest_path;
	FileInputStream fis;
	FileOutputStream fos;
	JFileChooser chooser;
	File f;
	JLabel label;
	long ori_size,dest_size;
	
	public FileCopy() {
		filecopy=this;
		bar = new JProgressBar();
		ori_open= new JButton("원본파일");
		dest_open= new JButton("목적지파일");
		copy= new JButton("복사하기");
		ori_path = new JTextField(30);
		dest_path = new JTextField(30);
		chooser= new JFileChooser("C:/");
		f = new File("C:/db_study");
		label = new JLabel();
		
		
		add(bar);
		add(ori_open);
		add(ori_path);
		add(dest_open);
		add(dest_path);
		add(copy);
		add(label);
		
		bar.setPreferredSize(new Dimension(400, 50));
		
		
		
		ori_open.addActionListener(this);
		dest_open.addActionListener(this);
		copy.addActionListener(this);
		
		
		setLayout(new FlowLayout());
		
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		
		if(obj==ori_open){
			open();
		}else if(obj == dest_open){
			dest_open();
		}else if(obj==copy){
			copy();
		}
		
	}
	
	public void open(){
		chooser.showOpenDialog(this);
		f=chooser.getSelectedFile();
		ori_path.setText(f.toString());
		ori_size =f.length();
		bar.setMaximum((int)ori_size);
		
	}
	public void dest_open(){
		chooser.showOpenDialog(this);
		f= chooser.getCurrentDirectory();
		dest_path.setText(f.toString());
		dest_size = f.length();
		
	}
	public void copy(){
		
		String oriPath = ori_path.getText();
		String destPath = dest_path.getText();
		
		StreamThread stream = new StreamThread(this, bar,oriPath, destPath,ori_size,dest_size,label);
				
	}
	
	public static void main(String[] args) {
		new FileCopy();
	}
}
