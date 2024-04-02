package Ch37_MVC_Add_View_Socket_Thread;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Controller.FrontController;

public class MVCServerRecvThread  implements Runnable{
	String clientIp;
	Socket client;
	ObjectInputStream Din;
	ObjectOutputStream Dout;
	MVCserver mvcServer;
	FrontController frontController;
	
	public MVCServerRecvThread(Socket client,MVCserver mvcServer){
		frontController = new FrontController();
		
		this.client=client;
		this.mvcServer = mvcServer;
		this.clientIp = client.getInetAddress().toString();
		
		try {
			Din = new ObjectInputStream(client.getInputStream());
			Dout = new ObjectOutputStream(client.getOutputStream());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			Object recv;
			while(true)
			{
				recv= Din.readObject(); //클라이언트의 전달 메시지를 수신
				if(recv!=null) {
					
					Response response  = (Response)recv;
					Map<String,Object>body =  response.getBody();
					String uri = (String)body.get("uri");
					Integer serviceNo =(Integer)body.get("serviceNo");
					Map<String,Object> params = (Map<String,Object>)body.get("params");

					//요구사항 요청
					Map<String,Object> returnValue =  frontController.execute(uri, serviceNo, params);
					//결과 Send하기
					mvcServer.Response(clientIp, returnValue);
					
				}	
				
			}	
		}catch(Exception e) {
			e.printStackTrace();	
			mvcServer.removeClient(this.clientIp);
		}
	}
	

}
