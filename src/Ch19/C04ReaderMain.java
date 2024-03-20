package Ch19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class C04ReaderMain {
	public static void main(String[] args) throws Exception {
		
		
		Reader fin =new FileReader("C:\\tmp_io\\test3.txt");
		StringBuffer buffer = new StringBuffer();
		
		char[] tmp = new char[1024];
		
		long startTime = System.currentTimeMillis();
		while(true) {
//			int data = fin.read();
			int data = fin.read(tmp);
			if(data==-1)
				break;
			//buffer.append((char)data);	
			buffer.append(tmp);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 : " + (endTime-startTime)+"ms");

		
		fin.close();
		
	}
}
