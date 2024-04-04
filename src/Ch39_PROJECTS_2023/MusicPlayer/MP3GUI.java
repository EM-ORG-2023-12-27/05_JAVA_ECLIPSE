package Ch39_PROJECTS_2023.MusicPlayer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultHighlighter;

class MP3GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	// MusicDbPath

	// Component
	JButton btn1;
	JButton btn2;
	JButton btn3;
	 
	JTextField txt1;
	JTextArea area1;
	MP3Player player;

	Map<String, String> playlist = new HashMap<String, String>();

	
	//글자클릭한 곳의 시작 offset
	int startOffset;
	//글자클릭한 곳의 끝 offset
	int endOffset;

	MP3GUI() {
		super(); // 상위클래스 생성자 호출

		setTitle("Listner적용하기");
		// 패널 추가
		JPanel pan1 = new JPanel();
		
		// Component
		btn1 = new JButton("검색");
		btn2 = new JButton("정지");
		btn3 = new JButton("랜덤");	
//		btn4 = new JButton("ETC");
		txt1 = new JTextField();
		area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);

		// Event_Action
		area1.addMouseListener(this);

		
		
		txt1.setBounds(10, 10, 100, 30); // 검색Text
		btn1.setBounds(120, 10, 60, 30); // 재생
		btn2.setBounds(190, 10, 60, 30); // 정지
		btn3.setBounds(260, 10, 60, 30); // 랜덤재생

		// area1.setBounds(50,50,190,280); // Scroll추가시 제거
		// 컴포넌트 위치 지정
		scroll1.setBounds(10, 50, 310, 280);
				

		// EVENT
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		txt1.addKeyListener(this);

		// 기타설정
		area1.setEditable(false);

		// 패널에 컴포넌트 추가
		pan1.add(btn1);
		pan1.add(btn2);
		pan1.add(btn3);
		pan1.add(txt1);
		// pan1.add(area1); // Scroll추가시 제거
		pan1.add(scroll1);

		// 레이아웃 null
		pan1.setLayout(null);

		// 패널을 프레임에 추가
		add(pan1);
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			// 검색
			System.out.println("검색 클릭");
			
		}
		if (e.getSource() == btn2) {
			// 정지
			player.close();		
		}

		if (e.getSource() == btn3) {
			//랜덤재생
			for(String key : playlist.keySet()) {
				System.out.println(playlist.get(key));
			}
			 
		}

		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	
	// START_PlayList가져오기
	public boolean getPlayList() {

		List<File> fileList = new ArrayList<>();
		listFiles(new File(MP3Player.MusicDbPath), fileList);

		for (File file : fileList) {
			System.out.println(file.getAbsolutePath()); // 절대경로
			System.out.println(file.getPath()); // 상대경로
			//전체플레이리스트에 저장
			playlist.put(file.getName(), file.getAbsolutePath());
			//Area에 각각의 MP3파일 리스트 붙이기
			area1.append(file.getName() + "\n");
		}

		return false;
	}

	public static void listFiles(File folder, List<File> fileList) {
		File[] files = folder.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					listFiles(file, fileList); // 하위 폴더의 파일도 검색하기 위해 재귀 호출
				} else {
					fileList.add(file);
				}
			}
		}
	}
	// END_PlayList가져오기
	
	
	// 마우스클릭시 이벤트 처리(클릭한 Textarea의 row값을 이용해서 클릭한 행의 Text추출하기)
	@Override
	public void mouseClicked(MouseEvent e) {
		
		try {	
		//모든 하이라이트 제거
		area1.getHighlighter().removeAllHighlights();

		System.out.println("마우스클릭됨..");
		int offset = area1.viewToModel(e.getPoint());
		int row;
		

			row = area1.getLineOfOffset(offset);
			startOffset = area1.getLineStartOffset(row);
			endOffset = area1.getLineEndOffset(row);
			String clickedText = area1.getText(startOffset, endOffset - startOffset);
			
			
			//클릭한 행의 하이라이트 색상을 회색으로
			area1.getHighlighter().addHighlight(startOffset, endOffset, new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY));
			
			
			System.out.println("Clicked text: " + clickedText);

			if (player != null) {
				// 기존의 재생음악은 정지시키고
				player.close();
			} 
			// 클릭한 곳의 음악을 찾아서 재생시켜야함
			player = new MP3Player(clickedText.trim());
			player.play();

		} catch (Exception e1) {
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
