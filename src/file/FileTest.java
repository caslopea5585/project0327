/*
 * �ڹٿ����� ���丮�� �����ϱ� ���� Ŭ������ ������ �������� �ʴ´�.
 * ���丮�� ���Ϸ� �����Ѵ�.
 * ��� : java.io.FileŬ������ ���� + ���丮���� ó���Ѵ�.
 * */

package file;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		//C����̺��� ������ �����ϴ� ��� ���丮 �� ������ ����غ���!
		File file= new File("C:/");
		
		//���� ���丮 �� ������ ��� �����ϱ�
		//String[] dir = file.list();
		
		File[] dir = file.listFiles();
		
		
		for(int i=0; i<dir.length;i++){
			if(dir[i].isDirectory()){
				System.out.println(dir[i].getName());
			}
		}
	}

}
