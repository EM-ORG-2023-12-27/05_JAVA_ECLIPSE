package Ch37_MVC_Add_View_Socket_Thread;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Controller.FrontController;
import Ch37_MVC_Add_View_Socket_Thread.View.Request;

public class MVCServerRecvThread  implements Runnable{
	String clientIp;
	Socket client;
	ObjectInputStream Din;
	MVCserver mvcServer;
	FrontController frontController;
	
	public MVCServerRecvThread(Socket client,MVCserver mvcServer){
		frontController = new FrontController();
		
		this.client=client;
		this.mvcServer = mvcServer;
		this.clientIp = client.getInetAddress().toString();
		
		try {
			Din = new ObjectInputStream(client.getInputStream());
			
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
					
					Request request  = (Request)recv;
					Map<String,Object>body =  request.getBody();
					String uri = (String)body.get("uri");
					Integer serviceNo =(Integer)body.get("serviceNo");
					Map<String,Object> params = (Map<String,Object>)body.get("params");

					System.out.printf("%s : %s , %s , %s\n",clientIp,uri,serviceNo,params);
					//요구사항 요청
					Map<String,Object> returnValue =  frontController.execute(uri, serviceNo, params);
					//결과 Send하기
					System.out.println("[MVC] resultVal : " + returnValue);
					mvcServer.Response(clientIp, returnValue);
					
				}	
				
			}	
		}catch(Exception e) {
			e.printStackTrace();	
			mvcServer.removeClient(this.clientIp);
		}
	}
	

}
