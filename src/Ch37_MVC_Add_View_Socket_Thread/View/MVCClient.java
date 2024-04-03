package Ch37_MVC_Add_View_Socket_Thread.View;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.MVCServerRecvThread;

public class MVCClient {
	Socket client;
	ObjectOutputStream out;
	Map<String,Object> receiveBody;
	
	MVCClient() throws UnknownHostException, IOException{
		//접속요청
		client = new Socket("192.168.2.254",5555);	
		System.out.println("[INIT] Server와 연결 완료");

		//수신스레드 
		MVCClientRecvThread recv = new MVCClientRecvThread(client,this);
		Thread th = new Thread(recv);
		th.start();
		
		
		this.out = new ObjectOutputStream(client.getOutputStream());
	}
	
	
	
	public void requestServer(Request request) throws Exception{
		 out.writeObject(request);
		 Thread.sleep(3000);	//수신 대기 
		 System.out.println("receiveBody : " + receiveBody);
	}



	public void recvObjects(Map<String, Object> body) {
		System.out.println("[INFO] RECV Objects : " + body);
		this.receiveBody = body;
	}
		 
		
	
}
