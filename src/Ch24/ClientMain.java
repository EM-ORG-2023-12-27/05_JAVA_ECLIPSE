package Ch24;

import java.net.ServerSocket;
import java.net.Socket;

public class ClientMain {

	public static void main(String[] args)  throws Exception{
		
		//

		//
		Socket client = new Socket("192.168.2.254",8000);
		//
		ServerSendThread send = new ServerSendThread(client);
		ServerRecvThread recv = new ServerRecvThread(client);
		//
		Thread th1 = new Thread(send);
		Thread th2 = new Thread(recv);
		//
		th1.start();
		th2.start();
		//
		th1.join();
		th2.join();
		
	}
}
