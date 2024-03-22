package Ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C01Server {

	public static void main(String[] args) throws IOException {
		
		//
		ServerSocket server = new ServerSocket(7000); //192.168.2.254:6000
		System.out.println("[INFO] Server Socket Listening...");
		
		while(true) {
			Socket client =  server.accept();
			System.out.println("[INFO] "+client.getInetAddress() + " 접속하셨습니다.");
			OutputStream out =  client.getOutputStream();
			DataOutputStream dout = new DataOutputStream(out);
			dout.writeUTF("WELCOME TO SERVER!");

			
			InputStream in =  client.getInputStream();
			DataInputStream din = new DataInputStream(in);
			String recv =  din.readUTF();
			System.out.println("[RECV] : " + recv);
			
			dout.flush();
			dout.close();
			out.close();	
			
		}
		

	}
	
}
