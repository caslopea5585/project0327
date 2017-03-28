/*
 *  OS가 여러 프로세스들을 동시에 수행하면서 관리할 수 있듯(Multi - Tasking)
 *  하나의 자바 프로그램내에서 세부적 실행단위를 만들어 동시에 수행시킬 수 있다.
 *  이러한 세부적 실행단위를 쓰레드라한다 .
 *  
 *  자바는 개발자가 정의하지 않아도 이미 기본적으로 제공되는 실행용 쓰레드가 있으며
 *  이러한 쓰레드를 가리켜 메인쓰레드라 한다.
 *  
 *  결국 자바는 쓰레드 기반이다!!
 *  
 * */

package thread;
public class ThreadTest {
	//메인 쓰레드 말고 개발자가 원하는 사용자 정의 쓰레드 하나 만들어서 원하는 동시 작업을 시켜보자!!!!
	
	MyThread thread ;
	
	public ThreadTest() {
		//메인쓰레드와는 독립적으로 실행 될 수 있는 세부 실행단위를 생성함.
		//쓰레드가 어떤일을 할지는 개발자가 결정해야 하기 때문에
		thread = new MyThread();
		
		//thread.run();
		//실행부가 독립적이 아니라 자기가 thread의 run()를 실행하러 갓다온다...
		//일반 메서드화 되어버린다...
		
		thread.start();
		//실행부를 하나 더 만드는거니깐 다른 실행부가 run을 찍으러가고 
		//메인실행부는 자기 갈길을 간다.
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("☆");
		}
	}
	
	
	public static void main(String[] args) {
		new ThreadTest();
		
	}

}
