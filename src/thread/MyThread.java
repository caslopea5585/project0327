/*
 * 	���� �����ϰ� ���� �ڵ�� �����ڰ� �����ؾ� �ϱ� ������
 * �����带 �������ؾ� �Ѵ�.
 * */
package thread;

public class MyThread extends Thread{
	/*
	 * �����ڴ� ���������� �����ϰ� ���� �ڵ带 �������� run�޼��� �ȿ� �ۼ��ϸ� �ȴ�.
	 * */
	
	
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("��");
			
		}
		
	}
}
