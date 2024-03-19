package Ch18;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


class C03GUI extends JFrame{
	
	C03GUI(){
		super("두번째 프레임입니다.");
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel생성
		JPanel panel = new JPanel();
		
		//배경색 지정
		Color col =new Color(237,247,183);
		panel.setBackground(col);
		
		//Frame에 Panel을 추가
		add(panel);
		
		setVisible(true);		
	}
}

public class C03SwingMain {
	public static void main(String[] args) {

		new C03GUI();
		
	}
}
