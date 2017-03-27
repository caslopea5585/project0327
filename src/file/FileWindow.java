/*
 * Ŭ������ �ڵ��� ���닚���� ���� ����̴�.
 * 
 * */
package file;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyIcon folder_on, folder_off;
	
	
	public FileWindow() {
		setLayout(new FlowLayout());
		
		//�̹��� �������� �����ϵ�, ���ҽ� �����κ���..
		//URL : Uniformed Resource Locator
		
		//res������ buildpath�� ��Ͻ�Ŵ���ν� ���� Ŭ�������� ���ϸ� �̸��� ���ָ�ȴ�.
		//folder_on= new ImageIcon(this.getClass().getResource("/folder_on.png"));
		//folder_off= new ImageIcon(this.getClass().getResource("/folder_off.png"));
		
		folder_on= new MyIcon(this.getClass().getResource("/folder_on.png"),50,50);
		folder_off= new MyIcon(this.getClass().getResource("/folder_off.png"),50,50);
		
		//�̹��� ũ�⸦ �����غ���
		Image scaledImg=folder_on.getImage();
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� �ٽ� ��ȯ����.
		Image result = scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		folder_on.setImage(result);
		
		//����� ������ �׽�Ʈ
		MyPanel mp = new MyPanel("workspace", folder_on);
		
		add(mp);
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new FileWindow();
	}

}
