package Ch37_MVC_Add_View_Socket_Thread;

import java.io.IOException;

import Ch37_MVC_Add_View_Socket_Thread.Properties.CommonProperties;
import Ch37_MVC_Add_View_Socket_Thread.Socket.ServerBackground;

public class Application {

	public static void main(String[] args) throws IOException {
		
		new ServerBackground().listenServer();
	}
}

