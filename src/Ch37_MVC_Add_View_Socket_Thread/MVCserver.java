package Ch37_MVC_Add_View_Socket_Thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MVCserver {
	
	ServerSocket server;
	Map<String,Socket> ClientList; //!!
	Socket client;
	
	
	public MVCserver(){
		
		ClientList = new HashMap();
		Collections.synchronizedMap(ClientList);//컬렉션 동기화 
		System.out.println("[INFO]MVC Server INIT");
	}
	
	//Client 접속 요청 수신용
	public void listenServer() {
		try {
			server = new ServerSocket(7777);
			while(true) {
				System.out.println("[INFO] SERVER LISTEN");
				client=server.accept();
				System.out.println(client.getInetAddress()+" 에서 접속중..");
				
				//수신 스레드 처리 
				MVCServerRecvThread recv = new MVCServerRecvThread(client,this);
				Thread th = new Thread(recv);
				th.start();
				
				//Server클라이언트 등록(IP주소 : Socket)
				ClientList.put(client.getInetAddress().toString(),client);

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//클라이언트 접속 제거
	public void removeClient(String ip) {
		System.out.println("[INFO] " + ip + " 와의 연결을 종료합니다.");
		ClientList.remove(ip);
	}
	
	//서버->클라이언트 응답용
	synchronized public void Response(String ip, Map<String,Object> response) throws IOException {
		
		Socket client =  ClientList.get(ip);
		ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
		out.writeObject(response);
		out.flush();
		out.close();
	}
	
	
}
