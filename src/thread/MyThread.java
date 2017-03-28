/*
 * 	동시 수행하고 싶은 코드는 개발자가 결정해야 하기 때문에
 * 쓰래드를 재정의해야 한다.
 * */
package thread;

public class MyThread extends Thread{
	/*
	 * 개발자는 독립적으로 수행하고 싶은 코드를 쓰레드의 run메서드 안에 작성하면 된다.
	 * */
	
	
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("★");
			
		}
		
	}
}
