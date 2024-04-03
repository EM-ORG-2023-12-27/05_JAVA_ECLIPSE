package Ch37_MVC_Add_View_Socket_Thread.Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Socket.Type.Response;

public class ClientRecvThread  implements Runnable{

	public Socket client;
	public ClientBackground mvcClient;
	ObjectInputStream in;
	public ClientRecvThread(Socket client, ClientBackground mvcClient) throws IOException {
		this.client =client;
		this.mvcClient = mvcClient;
		this.in = new ObjectInputStream(client.getInputStream());
	}

	@Override
	public void run() {
		
			
			Object recv = null;
			
			while(true)
			{

				try {recv= in.readObject();
				} catch (ClassNotFoundException e) {e.printStackTrace();
				} catch (IOException e) {e.printStackTrace();}

				//서버로부터의 메시지 수신
				if(in!=null) {
					Response response  = (Response)recv;
					Map<String,Object>body =  response.getBody();
					//
					mvcClient.recvObjects(body);	
				}
				
				//보조 스트림종료	
				try {in.close();} catch (IOException e) {e.printStackTrace();}
			
				
			}	
	
		
	}

}
