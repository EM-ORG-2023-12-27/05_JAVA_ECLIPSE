package Ch17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class C06PropertiesMain {

	public static void main(String[] args) throws Exception {
		
		
		Properties properties =new Properties();
				
		FileInputStream fin = new FileInputStream("C:\\Users\\Administrator\\Downloads\\새 폴더 (3)\\05_JAVA_ECLIPSE\\src\\Ch17\\application.properties");	
		properties.load(fin);
	
		String url=properties.getProperty("url");
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		
		System.out.printf("%s\n%s\n%s\n",url,username,password);
		
	}
}
