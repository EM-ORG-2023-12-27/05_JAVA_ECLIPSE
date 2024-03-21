package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C02INSERT {

	

	public static void main(String[] args) {
		//DB Conn Data
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://192.168.2.254:3306/testDB";
		
		//JDBC 참조변수
		Connection conn = null;				//DBMS 의 특정 DB연결을 위한 참조변수
		PreparedStatement pstmt = null;		//SQL 쿼리 전송용 참조변수
		ResultSet rs = null;				//SQL 쿼리중 조회결과(ex. SELECT) 수신용 참조변수
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이브 파일을 메모리공간에 적재
			System.out.println("Driver Loading Success..");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB Connected..");
			
			pstmt =	conn.prepareStatement("insert into tbl_std values(?,?,?)");
			pstmt.setString(1, "user1");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "홍길동");
			
			int result =  pstmt.executeUpdate();
			
			if(result>0)
				System.out.println("INSERT 성공");
			else
				System.out.println("INSERT 실패");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
	}
	
	
}
