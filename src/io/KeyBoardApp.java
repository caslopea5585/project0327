/*
	FileInputStream���� �����ڰ� ���ϴ� ������ ��Ʈ���� ������ �� ������, 
	Ű����� ���� ǥ�� �Է� �ϵ������ ��� �ڹٰ� ��Ʈ���� �������� ���ϰ�
	�ش� OS�� �����ϹǷ� �����ڴ� OS�κ��� ǥ���Է� ��Ʈ���� ���;� �Ѵ�..

	�ڹ��� Ŭ���� �� System Ŭ������ ����ƽ��� ������  has a����� ������ 
	InputStream�� in��ü�� �ٷ� ǥ�� �Է½�Ʈ���� �޾� ���� ��ü�̴�.
	���� ���ÿ� �׳� System.in!!!!!�� ����ϸ� ��.

	���ڱ�� ��Ʈ�� Ŭ������ �̸� ��Ģ.
	�Է� : ~~Reader
	��� : ~~Writer

*/


package io;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is = System.in;

		//���ڱ�� ��Ʈ���� �ܵ����� �����ϴ°��� �ƴ϶� �̹� ����Ʈ ��� ��Ʈ���� �������Ѵ�.
		//���� ������ �������� �μ��� ����Ʈ ��� ��Ʈ���� �ִ´�.

		InputStreamReader reader=null;
		reader = new InputStreamReader(is);

		
		int data;
		try{
			while(true){
				data = reader.read(); //2����Ʈ �о� ����...
				System.out.print((char)data);
			}
		}catch(IOException e){
			
		}
	}
}
