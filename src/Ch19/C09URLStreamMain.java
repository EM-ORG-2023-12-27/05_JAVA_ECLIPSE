package Ch19;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

public class C09URLStreamMain {
	
	public static void main(String[] args) throws Exception{
		
		URL url = new URL("https://n.news.naver.com/mnews/article/001/0014575456");
		InputStream bin =  url.openStream();
		
		BufferedInputStream buffIn = new BufferedInputStream(bin); 	//보조스트림
																	//버퍼공간추가
		
		Reader in = new InputStreamReader(buffIn);					//보조스트림
																	//byte단위->char단위로 변화해서받음
		
		Writer wout = new FileWriter("c:\\tmp_io\\index.html");
		
		while(true) {
			int data = in.read();
			if(data==-1)
				break;
			
			wout.write((char)data);
		}
		
		
		
	}
}
