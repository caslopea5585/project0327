/*
 * 아이콘 생성시 그 크기를 조정하려면 코드가 복잡하므로 앞으로 재사용 가능성을 염두해두고
 * 나만의 재조정 이미지 아이콘을 새로 정의해본다.
 */
package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{
	
	public MyIcon(URL url,int width, int height) {
		//안쪽이 먼저 수행되니깐... url을 변수처리해서 받아서 사용
		super(url);
		
		//이미지 아이콘을 새로만들필요갸없다 왜? extends로 받아버리니깐 자기자신이 이미지 아이콘이 된다.
		//is a 관계가 이미지 아이콘이므로 부모의 호출차를 생성하는꼴..
		//super(~~~~~~~~)부르며된다.
		//folder_off= new ImageIcon(this.getClass().getResource("/folder_off.png"));
		
		
		
		//이미지 크기를 조정해보자
		//Image scaledImg=folder_on.getImage();
		//자기이미지를 받아오니깐 this..로
		Image scaledImg=this.getImage();
		//크기를 재조정한 후 결과적으로 이미지 객체를 다시 반환받자.
		//Image result = scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		Image result = scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		//folder_on.setImage(result);
		this.setImage(result);

	}
}
