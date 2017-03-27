//패널이 라벨과 버튼을 가지고있다.
//Jpanel has a Label & Jbutton

package file;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JButton bt;
	JLabel la;
	
	//패널이 태어날때, 그 부품도 태어나야 하므로 생성자에서 초기화하자
	
	public MyPanel(String title, Icon icon) {
		la = new JLabel(title);
		bt = new JButton(icon);
		
		bt.setBorderPainted(false); // 경계선 없애기
		bt.setContentAreaFilled(false); //컨텐트영역 색채우기없음.
		bt.setFocusPainted(false); //선택됫을때 포커스 잡히는것... 포커스에 의한 경계없애기...
		bt.setOpaque(false); //불투명......이냐?
		
		
		this.setLayout(new BorderLayout());
		add(la,BorderLayout.NORTH);
		add(bt,BorderLayout.CENTER);
	}
	
}
