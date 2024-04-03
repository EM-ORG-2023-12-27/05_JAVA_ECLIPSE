package Ch37_MVC_Add_View_Socket_Thread.View;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Response;

public class MVCClientRecvThread  implements Runnable{

	public Socket client;
	public MVCClient mvcClient;
	public ObjectInputStream in;
	
	
	public MVCClientRecvThread(Socket client, MVCClient mvcClient) throws IOException {
		this.client =client;
		this.mvcClient = mvcClient;

	}

	@Override
	public void run() {
		
			
			Object recv = new Response();
			while(true)
			{
		
				try {
					in = new ObjectInputStream(client.getInputStream());
					recv= in.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//데이터 직렬화/역직렬화 구조 문제 해결 line-31 
				//java.io.StreamCorruptedException: invalid type code: AC
				
				
				//클라이언트의 전달 메시지를 수신
				if(recv!=null) {
						
						Response response  = (Response)recv;
						Map<String,Object>body =  response.getBody();
						
						mvcClient.recvObjects(body);		
				}	
					
			
				
			}	
	
		
	}

}
