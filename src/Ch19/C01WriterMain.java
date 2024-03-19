package Ch19;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01WriterMain {
	
	public static void main(String[] args) throws IOException {
		
		
		//Writer fout = new FileWriter("C:\\tmp_io\\test1.txt",false);//덮어쓰기
		Writer fout = new FileWriter("C:\\tmp_io\\test1.txt",true);//추가하기
		fout.write("TEST4\n");
		fout.write("TEST5\n");
		fout.write("TEST6\n");
		fout.flush();	//출력 버퍼 공간 초기화
		fout.close();	//출력 스트림 닫기
		
		
		
		
	}
}


