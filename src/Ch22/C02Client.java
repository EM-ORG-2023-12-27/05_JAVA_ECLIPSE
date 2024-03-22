package Ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Client {
	
	public static void main(String[] args) throws Exception {

		
		Socket client =  new Socket("192.168.2.254",7000);
		
		DataInputStream din = new DataInputStream(client.getInputStream());
		DataOutputStream dout = new DataOutputStream(client.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		String recv=null;
		String send=null;
		while(true)
		{
			//송신
			System.out.print("[ME(q:종료)] : ");
			send = sc.nextLine();
			dout.writeUTF(send);
			dout.flush();
			if(send.equals("q"))
				break;
			
			//수신
			recv = din.readUTF();
			if(recv.equals("q")||recv==null) {
				break;
			}
			System.out.println("[SERVER] : " + recv );

			
		}
		
		dout.close();
		din.close();
		
		
	}

}
