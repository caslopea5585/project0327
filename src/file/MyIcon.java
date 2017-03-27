/*
 * ������ ������ �� ũ�⸦ �����Ϸ��� �ڵ尡 �����ϹǷ� ������ ���� ���ɼ��� �����صΰ�
 * ������ ������ �̹��� �������� ���� �����غ���.
 */
package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{
	
	public MyIcon(URL url,int width, int height) {
		//������ ���� ����Ǵϱ�... url�� ����ó���ؼ� �޾Ƽ� ���
		super(url);
		
		//�̹��� �������� ���θ����ʿ䰼���� ��? extends�� �޾ƹ����ϱ� �ڱ��ڽ��� �̹��� �������� �ȴ�.
		//is a ���谡 �̹��� �������̹Ƿ� �θ��� ȣ������ �����ϴ²�..
		//super(~~~~~~~~)�θ���ȴ�.
		//folder_off= new ImageIcon(this.getClass().getResource("/folder_off.png"));
		
		
		
		//�̹��� ũ�⸦ �����غ���
		//Image scaledImg=folder_on.getImage();
		//�ڱ��̹����� �޾ƿ��ϱ� this..��
		Image scaledImg=this.getImage();
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� �ٽ� ��ȯ����.
		//Image result = scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		Image result = scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		//folder_on.setImage(result);
		this.setImage(result);

	}
}
