package homework;

public class Right_Thread extends Thread {
	CountApp countapp;
	int i=0;
	
	public void run() {
		
		
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			countapp.rv.setText(Integer.toString(i));
			i++;
		}
		
	}
	
	public Right_Thread(CountApp countapp) {
		this.countapp=countapp;
	}
}
