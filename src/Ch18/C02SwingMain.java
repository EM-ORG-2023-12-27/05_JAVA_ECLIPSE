package Ch18;

import javax.swing.JFrame;


class C02GUI extends JFrame{
	
	C02GUI(){
		super("두번째 프레임입니다.");
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
}

public class C02SwingMain {
	public static void main(String[] args) {

		new C02GUI();
		
	}
}
