package io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JPanel p_north;
	JButton bt_open, bt_save;
	ImageIcon icon;//�Ϲ�Ŭ����
	JTextArea area;
	JScrollPane scroll;
	
	String ori="C:/java_workspace2/project0327/res/memo2.txt"; //����
	String dest="C:/java_workspace2/project0327/res/memo2_copy.txt"; //�ٸ� ������ ������
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader; //���ڱ���� �Է½�Ʈ��.
	BufferedReader buffr; //���۵� ���ڱ�� �Է½�Ʈ��.
	
	//���ڱ���� ��½�Ʈ��!
	OutputStreamWriter writer;
	PrintWriter writer2; //���ڱ���� ��½�Ʈ��..outputStreamWriter�� �ѱ��� ����... �ٸ��� �Ẹ��..
	
	public MemoEditor() {
		p_north = new JPanel();
		icon = new ImageIcon("C:/java_workspace2/project0327/res/folder_on.png");	
		bt_open = new JButton(icon);
		bt_save = new JButton("����");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);
		
		
		p_north.add(bt_open);
		p_north.add(bt_save);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll,BorderLayout.CENTER);
		
		//��ư 2�� �����͸����� ����!
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();				
			}
		});
		
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();				
			}
		});
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//����
	public void open(){
		try {
			fis=new FileInputStream(ori);
			//���� ��� ��Ʈ������ �������ڵ� �Ӽ��� ������ �� �ִ�.
			reader = new InputStreamReader(fis,"utf-8");
			buffr = new BufferedReader(reader); //�Ѷ��ξ� �о����.
			
			String data;
			int count=0; //read�� Ƚ���� �˾ƺ�������!!
			
			while(true){
				//data =reader.read(); //2byte�о����. int���·� �о����..
				data=buffr.readLine(); // ���پ� String���·� �޾Ƶ���.
				count++;
				if(data==null) break;
				area.append(data+"\n"); 
			}
			System.out.println(count);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
			e.printStackTrace(); //�����ڸ� ���� ���� log����.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//�����ϱ�
	public void save(){
		try {
			//FileOutputStream�� ������ ����� ������ �����ع�����.(ũ��� 0����Ʈ�� empty����)
			fos = new FileOutputStream(dest);
			//writer = new OutputStreamWriter(fos, "utf-8");
			
			//writer.write(area.getText());
			writer2 = new PrintWriter(fos);
			writer2.write(area.getText());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  finally {
			//������� ������ ��Ʈ���� �ݾƾ� ������..
			//������� ��Ʈ���� ���� �ݴ� ó��
			
			if(writer2 !=null){
				writer2.close();			
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new MemoEditor();

	}

}
