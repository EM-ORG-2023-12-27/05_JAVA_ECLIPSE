package Ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {
	
	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(7000); //192.168.2.254:6000
		System.out.println("[INFO] Server Socket Listening...");
		
		Socket client =  server.accept();
		System.out.println("[INFO] Client Accepted.." + client.getInetAddress());
		DataInputStream din = new DataInputStream(client.getInputStream());
		DataOutputStream dout = new DataOutputStream(client.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		String recv=null;
		String send=null;
		while(true)
		{
			//수신
			recv = din.readUTF();
			if(recv.equals("q")||recv==null) {
				break;
			}
			System.out.println("[CLIENT] : " + recv );
			
			//송신
			System.out.print("[ME(q:종료)] : ");
			send = sc.nextLine();
			dout.writeUTF(send);
			dout.flush();
			if(send.equals("q"))
				break;
			
		}
		System.out.println("종료 되었습니다..");
		dout.close();
		din.close();
		
	}
}






