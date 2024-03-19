package Ch18;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;


class C05GUI extends JFrame implements ActionListener,KeyListener,MouseListener{
	
	JButton btn1;
	JButton btn2;
	JTextField txt1;
	JTextField txt2;
	JTextArea area1;
	JScrollPane scroll1;
	C05GUI(){
		super("두번째 프레임입니다.");
		setBounds(100,100,250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel생성
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//Panel 배경색 지정
		Color col =new Color(237,247,183);
		panel.setBackground(col);
		
		//Btn_component 추가
		btn1 = new JButton("Button01");
		btn1.setBounds(10,10,100,30);
		
		
		btn2 = new JButton("Button02");
		btn2.setBounds(120,10,100,30);		
		
		//TextField_component 추가
		txt1 = new JTextField();
		txt1.setBounds(10,50,210,30);
		txt2 = new JTextField();
		txt2.setBounds(10,90,210,30);
		
		//TextArea_component 추가
		area1 = new JTextArea();
		//area1.setBounds(10,130,210,200);
		
		//ScrollPanel_component 추가
		scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,130,210,200);
		
		
		//Event에 Component 등록
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		txt1.addKeyListener(this);
		//txt2.addKeyListener(this);
		area1.addMouseListener(this);
		
		
		
		
		//Component를 Panel에 추가
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
		panel.add(txt2);
		//panel.add(area1);
		panel.add(scroll1);
		
		
		//Frame에 Panel을 추가
		add(panel);
		
		
		super.setResizable(false);
		setVisible(true);		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btn1) {
			System.out.println("btn1 Clicked..");
		}
		else if(e.getSource()==btn2) {
			System.out.println("btn2 Clicked..");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//키를 눌렀을때/뗏을때(UNICODE 문자)
//		System.out.println("keyTyped.."+e.getKeyChar());
//		System.out.println("keyTyped..."+e.getKeyCode());
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//키를 눌렀을때
//		System.out.println("keyPressed..."+e.getKeyChar());
//		System.out.println("keyPressed..."+e.getKeyCode());
		if(e.getSource()==txt1) {	
			if(e.getKeyCode()==10) {
				//txt1의 문자열을 textarea에 덧붙이기
				//txt1의 값은 초기화
				String message = txt1.getText();
				area1.append(message+"\n");
				txt1.setText("");
			}	
		}
		 
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//키를 뗏을때(UNICODE 미지원)
//		System.out.println("keyReleased..."+e.getKeyChar());
//		System.out.println("keyPressed..."+e.getKeyCode());
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		try 
		{
			System.out.println("mouseClicked..."+e.getPoint());
			int offset = area1.viewToModel(e.getPoint());
			System.out.println("offset : " + offset);
			int row = area1.getLineOfOffset(offset);
			System.out.println("row : " + row);//0번부터
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
			String getStr= area1.getText(startOffset,endOffset-startOffset);
			System.out.println("message : "+getStr);
			
		} catch (BadLocationException e1) {
		
			e1.printStackTrace();
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

public class C05SwingMain {
	public static void main(String[] args) {

		new C05GUI();
		
	}
}
