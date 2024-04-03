package Ch37_MVC_Add_View_Socket_Thread.View;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.MVCServerRecvThread;

public class MVCClient {
	public Socket client;
	public ObjectOutputStream out;
	public Map<String,Object> receiveBody;
	
	public MVCClient(){
		//접속요청
		try {
			client = new Socket("192.168.2.254",7777);
		
			System.out.println("[INIT] Server와 연결 완료.." + client);

			this.out = new ObjectOutputStream(client.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public void requestServer(Request request) throws Exception{
		 
		 out.writeObject(request);
		 out.flush();
		 Thread.sleep(3000);	//수신 대기 
		 System.out.println("receiveBody : " + receiveBody);
	}

	public void recvObjects(Map<String, Object> body) {
		System.out.println("[INFO] RECV Objects : " + body);
		this.receiveBody = body;
	}
		 
		
	
}
