//������ ������ ��� �� ������!
package thread;
public class MoveThread extends Thread{
	AniMain aniMain;
	
	
	public MoveThread(AniMain aniMain) {
		this.aniMain =aniMain;
	}
	
	//�����ڴ� ���� ������ �ڵ带 run�� �����Ѵ�.
	//JVM�� run���� �˾Ƽ� ȣ�����ش�.
	public void run() {
		while(true){
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.aniMain.move();
		}
	}

	
	
}
