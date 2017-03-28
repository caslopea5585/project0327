package homework3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class StreamThread extends Thread {
	FileCopy filecopy;
	JProgressBar bar;
	String oriPath,destPath;
	FileInputStream fis;
	InputStreamReader reader;
	BufferedReader buffr;
	FileOutputStream fos;
	OutputStreamWriter writer2;
	String data;
	int count;
	long ori_size,dest_size;
	float percent=0;
	JLabel label;
	
	public void run() {
		while(true){
			try {
				Thread.sleep(10);
				data = buffr.readLine();
				if(data==null)break;
				
				writer2.write(data);
				
				System.out.println("data 크기?"+data.length());
				count +=data.length();
				System.out.println("count"+count+"dest"+dest_size);
				
				
				/*//fos.write(data);
				count++;
				bar.setValue(count);
				percent = (float)count/(float)ori_size *100;
				label.setText(Integer.toString((int)percent)+"%");*/
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
		JOptionPane.showMessageDialog(filecopy, "복사완료");
		
	
	}
	public StreamThread(FileCopy filecopy,JProgressBar bar, String oriPath, String destPath,long ori_size,long dest_size,JLabel label) {
		this.filecopy = filecopy;
		this.bar = bar;
		this.oriPath = oriPath;
		this.destPath = destPath;
		this.ori_size = ori_size;
		this.dest_size= dest_size;
		this.label = label;
		
		
		try {
			fis = new FileInputStream(oriPath);
			reader = new InputStreamReader(fis,"utf-8");
			buffr = new BufferedReader(reader);
					
			fos = new FileOutputStream(destPath);
			writer2 = new OutputStreamWriter(fos,"utf-8");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(ori_size);
		start();
		
	}
}
