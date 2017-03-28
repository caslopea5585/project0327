package thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//개발자가 쓰레드를 상속하여 개발 할 수 있으나, 이미 다른클래스의 자식일 경우 상속은 불가하다....
//이럴때 사용할 수 있는 객체가 바로 Runnable인터페이스이다.


//상속을 받을 수 없는 경우에 이득이 될 수 있다.
public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas can;
	int x, y;
	Thread thread; //내부익명 스타일로 가자
	
	public AniMain() {
		//Runnable인 객체를 인수로 넘긴다. 그러면, run메서드는 호출은 Runnable을 
		//재정의한 객체의 run을 호출한다. 
		thread = new Thread(this);
		bt= new JButton("물체 이동");
		add(bt, BorderLayout.NORTH);
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		
		
		can.setBackground(Color.YELLOW);
		
		add(can);
		
		//버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
					
				
			}
		});
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void move(){
		x+=5;
		can.repaint();
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			move();
		}
	}
	
	public static void main(String[] args) {
		new AniMain();
	}

	

}
