/*
 * Ŭ������ �ڵ��� ���닚���� ���� ����̴�.
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
		
		//�̹��� �������� �����ϵ�, ���ҽ� �����κ���..
		//URL : Uniformed Resource Locator
		
		//res������ buildpath�� ��Ͻ�Ŵ���ν� ���� Ŭ�������� ���ϸ� �̸��� ���ָ�ȴ�.
		//folder_on= new ImageIcon(this.getClass().getResource("/folder_on.png"));
		//folder_off= new ImageIcon(this.getClass().getResource("/folder_off.png"));
		
		folder_on= new MyIcon(this.getClass().getResource("/folder_on.png"),50,50);
		folder_off= new MyIcon(this.getClass().getResource("/folder_off.png"),50,50);
		
		//�̹��� ũ�⸦ �����غ���
		//Image scaledImg=folder_on.getImage();
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� �ٽ� ��ȯ����.
		//Image result = scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		//folder_on.setImage(result);
		
		//����� ������ �׽�Ʈ
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

	
	
	//���ϴ� ����� ���� ���丮  & ���� ���ϱ�
	public ArrayList getDirList(){
		File file = new File("C:/");
		File[] fileList = file.listFiles();
		ArrayList<String> dirList = new ArrayList<String>();
		
		
		//���丮�� �����....
		for(int i=0; i<fileList.length;i++){
			if(fileList[i].isDirectory()){
				//���丮�� �߰ߵɋ����� ����Ʈ�� �߰�����
				dirList.add(fileList[i].getName());
			}
			
		}
		
		return dirList;
		
	}
	
	public static void main(String[] args) {
		new FileWindow();
	}

}
