package homework3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.omg.PortableServer.ServantRetentionPolicyValue;

public class FileCopyProgress extends JFrame{

	JFileChooser chooser;
	JProgressBar progressBar;
	JPanel first,second;
	JButton open, save,start;
	JTextField openPath, savePath;
	
	FileInputStream fis;
	FileOutputStream fos;
	
	FileReader fr;
	FileWriter fw;
	

	
	
	File f;
	
	
	public FileCopyProgress() {
		progressBar = new JProgressBar();
		first = new JPanel();
		second = new JPanel();
		
		open = new JButton("열기");
		save = new JButton("저장경로열기");
		start = new JButton("복사시작");
		
		openPath = new JTextField(30);
		savePath = new JTextField(30);
		

		
		chooser= new JFileChooser("C:/");
		f= new File("C:/db_study");

		
		first.add(open);
		first.add(openPath);
		
		second.add(save);
		second.add(savePath);
		
		progressBar.setPreferredSize(new Dimension(300, 50));
		first.setPreferredSize(new Dimension(400, 100));
		second.setPreferredSize(new Dimension(400, 100));
		
	
		add(progressBar);
		add(first);
		add(second);
		add(start);
		
		
		open.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				openFilePath();				
			}
		});
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFilePath();
			}
		});
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyStart();
			}
		});
		
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
	}
	public void copyStart(){
		String oriPath = openPath.getText();
		String destPath = savePath.getText();
		
		try {
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath);
			
			fr = new FileReader(oriPath);
			fw = new FileWriter(destPath);
			
			//fr.read();
			
			int data;
			
			while(true){
				
				data = fis.read();
				if(data==-1)break;
				fos.write(data);
				
			}
			JOptionPane.showMessageDialog(this, "복사완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(fis!=null){fis.close();}
				if(fos!=null){fos.close();}
			}catch(IOException e ){
			
			}
			
		}
		
		
		
	}
	public void saveFilePath(){
		chooser.showOpenDialog(this);
		f = chooser.getCurrentDirectory();
		savePath.setText(f.getPath()+"/");
		System.out.println(savePath.getText());
		
	}
	
	public void openFilePath(){
		chooser.showOpenDialog(this);
		 f = chooser.getSelectedFile();
		openPath.setText(f.getPath());
		
	}
	
	
	public static void main(String[] args) {
		new FileCopyProgress();
	}

}
