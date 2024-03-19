package Ch19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class C03FileCopyMain {

	private static String FileDir = "c:\\tmp_io\\";
	
	public static void main(String[] args) throws Exception{
		// (c:\\tmp_io)
		for(String arg : args)
			System.out.println(arg);
		
		Reader in = new FileReader(FileDir+args[0]);
		Writer out = new FileWriter(FileDir+args[1]);
		
		while(true) {
			int data = in.read();
			if(data==-1)
				break;
			out.write((char)data);
			out.flush();
		}
		in.close();
		out.close();
		
	}
}





