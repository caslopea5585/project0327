/*
 * 클래스는 코드의 재사용떄문에 나온 기술이다.
 * 
 * */
package file;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyIcon folder_on, folder_off;
	ArrayList<MyPanel> zip_panel;
	
	public FileWindow() {
		setLayout(new FlowLayout());
		
		//이미지 아이콘을 생성하되, 리소스 폴더로부터..
		//URL : Uniformed Resource Locator
		
		//res폴더를 buildpath에 등록시킴으로써 현재 클래스에서 파일명 이름만 써주면된다.
		//folder_on= new ImageIcon(this.getClass().getResource("/folder_on.png"));
		//folder_off= new ImageIcon(this.getClass().getResource("/folder_off.png"));
		
		folder_on= new MyIcon(this.getClass().getResource("/folder_on.png"),50,50);
		folder_off= new MyIcon(this.getClass().getResource("/folder_off.png"),50,50);
		
		//이미지 크기를 조정해보자
		//Image scaledImg=folder_on.getImage();
		//크기를 재조정한 후 결과적으로 이미지 객체를 다시 반환받자.
		//Image result = scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		//folder_on.setImage(result);
		
		//제대로 붙을지 테스트
		ArrayList<String> list = getDirList();
		zip_panel= new ArrayList<MyPanel>();
		
		for(int i=0;i<list.size();i++){
			String dirName = list.get(i);
			MyPanel mp = new MyPanel(dirName, folder_off);
			zip_panel.add(mp);
			mp.bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int z=0; z<zip_panel.size();z++){
						zip_panel.get(z).bt.setIcon(folder_off);	
					}
					mp.bt.setIcon(folder_on);
				}
			});
			add(mp);
		}
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	
	
	//원하는 경로의 하위 디렉토리  & 파일 구하기
	public ArrayList getDirList(){
		File file = new File("C:/");
		File[] fileList = file.listFiles();
		ArrayList<String> dirList = new ArrayList<String>();
		
		
		//디렉토리만 골라내자....
		for(int i=0; i<fileList.length;i++){
			if(fileList[i].isDirectory()){
				//디렉토리가 발견될떄마다 리스트에 추가하자
				dirList.add(fileList[i].getName());
			}
			
		}
		
		return dirList;
		
	}
	
	public static void main(String[] args) {
		new FileWindow();
	}

}
