package Ch36.Tests;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpTests {
	public static void main(String[] args) {
		
		
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("");
		config.setUsername("root");
		config.setPassword("1234");
		
		//최대 Connection 개수
		config.setMaximumPoolSize(10);
		
		HikariDataSource dataSource = new HikariDataSource(config);
	
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			//DB 코드 작성
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
}	
