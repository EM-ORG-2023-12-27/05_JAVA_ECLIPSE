package Ch37_MVC_Add_View_Socket_Thread.View.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.BookDto;
import Ch37_MVC_Add_View_Socket_Thread.Socket.ClientBackground;
import Ch37_MVC_Add_View_Socket_Thread.Socket.ClientRecvThread;
import Ch37_MVC_Add_View_Socket_Thread.Socket.Type.Request;
import Ch37_MVC_Add_View_Socket_Thread.View.GUI.AUTH.LoginUI;

public class MainGUI extends JFrame implements ActionListener {

	
	
	JTable table;
	JScrollPane tableScroll;
	JLabel label;
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
		label = new JLabel("BOOKCODE : ");
		table = new JTable(model);
		tableScroll = new JScrollPane(table);
		
		txt = new JTextField();
		btn1 = new JButton("도서조회");
		btn2 = new JButton("회원가입");
		btn3 = new JButton("로그인");
		
		
		// 위치 조정
		label.setBounds(10,10,200,15);
		txt.setBounds(10,30,200,30);
		btn1.setBounds(350,10,100,30);
		btn2.setBounds(350,50,100,30);
		btn3.setBounds(350,90,100,30);
		tableScroll.setBounds(10,140,440,200);
		
		//EVENT
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		// 컴포넌트를 패널에 추가
		panel.add(label);
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
		
		if(e.getSource()==btn1)	//도서조회 
		{
			String bookCode =  txt.getText();
			System.out.println("BTN1 CLICK bookCode " + bookCode);
			
			
			Request request = new Request();
			Map<String,Object> body = new HashMap();
			body.put("uri", "/book");
			Map<String,Object> params = new HashMap();
			Integer serviceNo =-1;
			if(bookCode.equals("")) {
				body.put("serviceNo", 4); //전체 조회
				serviceNo=4;
			}
			else {
				body.put("serviceNo", 5); //bookCode 조회
				serviceNo=5;
				params.put("bookCode", Integer.parseInt(bookCode));
				body.put("params", params);
			}

			request.setBody(body);
			try {				
				clientBackground.requestServer(request);
				Thread.sleep(3000);
			} catch (Exception e1) {			
				e1.printStackTrace();
			}

			Map<String,Object>response =  clientBackground.receiveBody;
			System.out.println("MAIN GUI Response : " + response);
			
			List<BookDto> list =  (List<BookDto>) response.get("list");
			System.out.println("LIST : " + list);
			
			//Table Setting
			//테이블 구조생성		
			String[] column = {"도서코드", "도서명", "출판사","ISBN"};
			Object[][] data = {};
			DefaultTableModel model = new DefaultTableModel(data,column);
			for(BookDto dto : list) {
				Object[] rowData = {dto.getBookCode(),dto.getBookName(),dto.getPublisher(),dto.getIsbn()};
				model.addRow(rowData);
			}

			table.setModel(model);

			
	
			
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
