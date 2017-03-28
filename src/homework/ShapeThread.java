/*
 * 원이던 사각형이던 어떤 도형을 표현한 객체이던 모두 이 클래스의 자식으로 두자
 * 왜?? 공통적 특징이 있으므로
 * */
package homework;

import java.awt.Color;
import java.awt.Graphics;

abstract public class ShapeThread extends Thread{
	int x; 
	int y;
	int width;
	int height;
	int interval;
	Graphics g;
	
	public ShapeThread(int x, int y, int width, int height, int interval,Graphics g){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval= interval;
		this.g=g;
		
		start();
	}
	
	abstract public void render();
	
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}
	}
}
