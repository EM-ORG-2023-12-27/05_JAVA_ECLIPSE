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
		this.in = new ObjectInputStream(client.getInputStream());
	}

	@Override
	public void run() {
		
			Object recv=null;
			while(true)
			{
		
				try {
					recv= in.readObject();
				}catch (EOFException e) {
					System.out.println("EOF..수신된 내용없음");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				
				//클라이언트의 전달 메시지를 수신
				if(recv!=null) {
					
					Response response  = (Response)recv;
					Map<String,Object>body =  response.getBody();
					
					mvcClient.recvObjects(body);

					
				}	
				
			}	
	
		
	}

}
