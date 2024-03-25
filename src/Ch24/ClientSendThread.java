package Ch24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSendThread  implements Runnable{

	Scanner sc;
	Socket socket;
	DataOutputStream dout;
	
	ClientSendThread(Socket socket){
		this.socket = socket;
		this.sc = new Scanner(System.in);
	}
	
	@Override
	public void run() {
		try {
			dout = new DataOutputStream(  socket.getOutputStream() );
			while(true) {
				System.out.print("[CLIENT(q:종료)] : ");
				String send = sc.nextLine();
				dout.writeUTF(send);
				dout.flush();
				if(send.equals("q"))
					break;		
			}
			
			System.out.println("[INFO] 종료합니다.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
}
