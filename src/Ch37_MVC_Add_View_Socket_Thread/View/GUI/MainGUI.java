package Ch37_MVC_Add_View_Socket_Thread.View.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Ch37_MVC_Add_View_Socket_Thread.Socket.ClientBackground;
import Ch37_MVC_Add_View_Socket_Thread.Socket.ClientRecvThread;
import Ch37_MVC_Add_View_Socket_Thread.View.GUI.AUTH.LoginUI;

public class MainGUI extends JFrame implements ActionListener {

	
	
	JTable table;
	JScrollPane tableScroll;
	JTextField txt;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	
	//
	public LoginUI loginUI;
	
	//
	public Integer mySessionId;
	
	//
	public ClientBackground clientBackground;
	
	public MainGUI() throws IOException {

		super("MAIN MENU");
		setBounds(10, 10, 500, 400);

		// 패널
		JPanel panel = new JPanel();
		panel.setLayout(null);

		
		//테이블 열이름
		String[] columnNames = {"도서코드", "도서명", "출판사","ISBN"};
		// 테이블 데이터 x 
		//테이블 모델
		DefaultTableModel model = new DefaultTableModel(columnNames,0);
		
		
		// 컴포넌트
		table = new JTable(model);
		tableScroll = new JScrollPane(table);
		
		txt = new JTextField("bookcode");
		btn1 = new JButton("도서조회");
		btn2 = new JButton("회원가입");
		btn3 = new JButton("로그인");
		
		
		// 위치 조정
		txt.setBounds(10,10,200,30);
		btn1.setBounds(350,10,100,30);
		btn2.setBounds(350,50,100,30);
		btn3.setBounds(350,90,100,30);
		tableScroll.setBounds(10,140,440,200);
		
		//EVENT
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		// 컴포넌트를 패널에 추가
		panel.add(txt);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(tableScroll);
		
		//EVENT
		
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//loginUI
		loginUI = new LoginUI();
		loginUI.setVisible(false);
		loginUI.setMainUI(this);
	
		this.mySessionId = 0;	//로그인된상태x
		
		//소켓 연결 시도 
		this.clientBackground = new ClientBackground(); 
		System.out.println("MVCClient : " + clientBackground);
	
		//소켓 수신스레드 생성
		ClientRecvThread recv = new ClientRecvThread(clientBackground.client,clientBackground);
		Thread th = new Thread(recv);
		th.start();
		System.out.println("[INIT] 수신 스레드 생성완료 " + recv);
	
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn1) {
			System.out.println("BTN1 CLICK ");
		}
		else if(e.getSource()==btn2) {
			System.out.println("BTN2 CLICK ");
		}
		else if(e.getSource()==btn3) //로그인 요청
		{
			System.out.println("BTN3 CLICK ");
			
			
			loginUI.setVisible(true);
			loginUI.setMainUI(this);
			System.out.println("MVCCLIENT : " + clientBackground);
			loginUI.setMVCClient(clientBackground);
			this.setVisible(false);
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		new MainGUI();
	}
}
