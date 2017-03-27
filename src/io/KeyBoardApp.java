/*
	FileInputStream등은 개발자가 원하는 시점에 스트림을 생성할 수 있지만, 
	키보드와 같은 표준 입력 하드웨어의 경우 자바가 스트림을 생성하지 못하고
	해당 OS가 관리하므로 개발자는 OS로부터 표준입력 스트림을 얻어와야 한다..

	자바의 클래스 중 System 클래스의 스태틱멤버 변수중  has a관계로 보유한 
	InputStream형 in객체가 바로 표준 입력스트림을 받아 놓은 객체이다.
	따라서 사용시엔 그냥 System.in!!!!!만 사용하면 됨.

	문자기반 스트림 클래스의 이름 규칙.
	입력 : ~~Reader
	출력 : ~~Writer

*/


package io;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is = System.in;

		//문자기반 스트림은 단독으로 존재하는것이 아니라 이미 바이트 기반 스트림을 전제로한다.
		//따라서 생성시 생성자의 인수에 바이트 기반 스트림을 넣는다.

		InputStreamReader reader=null;
		reader = new InputStreamReader(is);

		
		int data;
		try{
			while(true){
				data = reader.read(); //2바이트 읽어 들임...
				System.out.print((char)data);
			}
		}catch(IOException e){
			
		}
	}
}
