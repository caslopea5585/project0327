package homework2;

import javax.swing.JLabel;

public class CountThread extends Thread{
	JLabel la;
	int interval;
	int count;
	
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
			//Ư�� ���� ���� 1�� ������Ű�� ������ �ӵ����...
			count++;
			la.setText(Integer.toString(count));
		}
	}
	public CountThread(JLabel la, int interval) {
		this.la = la;
		this.interval=interval;
		
		this.start();
	}
	
	
}
