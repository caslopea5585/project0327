//�г��� �󺧰� ��ư�� �������ִ�.
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
	
	//�г��� �¾��, �� ��ǰ�� �¾�� �ϹǷ� �����ڿ��� �ʱ�ȭ����
	
	public MyPanel(String title, Icon icon) {
		la = new JLabel(title);
		bt = new JButton(icon);
		
		this.setLayout(new BorderLayout());
		add(la,BorderLayout.NORTH);
		add(bt,BorderLayout.CENTER);
	}
	
}
