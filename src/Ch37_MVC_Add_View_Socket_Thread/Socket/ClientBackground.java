package Ch37_MVC_Add_View_Socket_Thread.Socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Socket.Type.Request;

public class ClientBackground {
	public Socket client;
	public Map<String,Object> receiveBody;
	
	public ClientBackground(){
		//접속요청
		try {
			client = new Socket("172.22.224.1",8888);
			System.out.println("[INIT] Server와 연결 완료.." + client);

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public void requestServer(Request request) throws Exception{
		ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
		out.writeObject(request);
		out.flush();
		out.close();
		Thread.sleep(3000);	//수신 대기 
		System.out.println("[Client] requestServer's receiveBody : " + receiveBody);
	}

	public void recvObjects(Map<String, Object> body) {
		System.out.println("[Client] recvObjects's receiveBody : " + body);
		this.receiveBody = body;
	}
		 
		
	
}
