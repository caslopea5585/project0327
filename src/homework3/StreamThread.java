package homework3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class StreamThread extends Thread {
	FileCopy filecopy;
	JProgressBar bar;
	String oriPath,destPath;
	FileInputStream fis;
	FileOutputStream fos;
	int data;
	int count;
	long ori_size,dest_size;
	float percent=0;
	JLabel label;
	
	public void run() {
		while(true){
			try {
				Thread.sleep(10);
				data = fis.read();
				if(data==-1)break;
				fos.write(data);
				count++;
				bar.setValue(count);
				percent = (float)count/(float)ori_size *100;
				label.setText(Integer.toString((int)percent)+"%");
				
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
			fos = new FileOutputStream(destPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(ori_size);
		start();
		
	}
}
