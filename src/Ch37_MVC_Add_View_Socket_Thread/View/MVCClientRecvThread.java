package Ch37_MVC_Add_View_Socket_Thread.View;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Response;

public class MVCClientRecvThread  implements Runnable{

	Socket client;
	MVCClient mvcClient;
	ObjectInputStream in;
	
	public MVCClientRecvThread(Socket client, MVCClient mvcClient) throws IOException {
		this.client =client;
		this.mvcClient = mvcClient;
		this.in = new ObjectInputStream(client.getInputStream());
	}

	@Override
	public void run() {
		try {
			Object recv;
			while(true)
			{
				recv= in.readObject(); //클라이언트의 전달 메시지를 수신
				if(recv!=null) {
					
					Response response  = (Response)recv;
					Map<String,Object>body =  response.getBody();
					
					mvcClient.recvObjects(body);

					
				}	
				
			}	
		}catch(Exception e) {
			e.printStackTrace();	
		}
		
	}

}
