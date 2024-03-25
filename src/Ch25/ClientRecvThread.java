package Ch25;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientRecvThread  implements Runnable{

	Socket socket;
	DataInputStream din;
	Cgui gui;
	
	ClientRecvThread(Socket socket,Cgui gui){
		this.socket = socket;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		try {
			
			din = new DataInputStream(socket.getInputStream());
			String recv=null;
			while(true) {
				recv = din.readUTF();
				if(recv.equals("q")|| recv==null)
					break;
				System.out.println("[SERVER] :"+recv);
				gui.area.append("[SERVER] :"+recv+"\n");
			}
			System.out.println("[INFO] 수신을 종료합니다.");
			gui.area.append("[SERVER] 와의 연결을 종료합니다. \n");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
