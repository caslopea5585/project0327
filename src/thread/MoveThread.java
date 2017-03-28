//움직임 로직을 담게 될 쓰레드!
package thread;
public class MoveThread extends Thread{
	AniMain aniMain;
	
	
	public MoveThread(AniMain aniMain) {
		this.aniMain =aniMain;
	}
	
	//개발자는 독립 실행할 코드를 run에 기재한다.
	//JVM이 run알을 알아서 호출해준다.
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
