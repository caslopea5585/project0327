package homework;

public class Left_Thread extends Thread{
	
	CountApp countapp;
	int i=0;
	public void run() {
		
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			countapp.lv.setText(Integer.toString(i));
			i++;
		}
		
	}
	
	public Left_Thread(CountApp countapp) {
		this.countapp=countapp;
	}
}
