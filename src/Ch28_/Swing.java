package Ch28_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C05GUI extends JFrame implements ActionListener,KeyListener
{
	
	JTextArea area;
	JScrollPane scroll;
	JTextField txt1;
	ImgCrowling crowling;
	
	C05GUI(){
		super("다섯번째 프레임입니다.");	//프레임창 제목
		
		JPanel pannel = new JPanel(); //패널 생성
		
		pannel.setLayout(null);	//Layout 설정 x
		
		
		
		area = new JTextArea();	//텍스트영역창
		//area.setBounds(10,10,260,240);	//스크롤 추가시 생략
		
		scroll = new JScrollPane(area); //area에 스크롤 추가하기
		scroll.setBounds(10,50,560,400);
		
		txt1 = new JTextField();			//텍스트입력창 
		txt1.setText("https://");
		txt1.setBounds(10,10,260,30);		//크기
		txt1.addKeyListener(this);			//이벤트 추가(키보드)
		

		pannel.add(txt1);
		//pannel.add(area);		//스크롤 추가시 생략
		pannel.add(scroll);
		
		add(pannel);			//프레임에 패널 추가
		
		setBounds(100,100,600,500);	//프레임창 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료버튼 사용가능상태
		setVisible(true);	//프레임창 보여주기
		
		crowling = new ImgCrowling();
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	}

	//키를 뗏을때(UNICODE지원)
	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("KEYTPYED함수 : " + e.getKeyChar());
		
	}
	//키를 눌렀을때
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("KEYPRESSED함수 : "+e.getKeyChar());
		//System.out.println("KEYPRESSED함수 : "+e.getKeyCode());

		if(e.getKeyCode()==10) //엔터키 입력
		{
			crowling.setURL(txt1.getText());
			List<String> list = crowling.Crowling();
			
			
			area.setText("");
			int i=1;
			for(String filename : list) {
				
				area.append(i+". "+filename.toString()+"\n");
				//System.out.println(filename);
				i++;
			}
			txt1.setText("https://");
			
			
			
		}
	}
	//키를 뗏을때(UNICODE 미지원)
	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("KEYRELEASED함수 : "+e.getKeyChar());
		
	}

	 
}

public class Swing {

	public static void main(String[] args) {
		new C05GUI();
	}

}
