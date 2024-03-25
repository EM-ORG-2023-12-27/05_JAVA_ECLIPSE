package Ch24;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		
		//
		ServerSocket server = new ServerSocket(9000);
		System.out.println("SERVER SOCKET START...");
		//
		Socket client = server.accept();
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
