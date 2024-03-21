package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Student{
	private String userid;
	private String password;
	private String name;
	
	//생성자(모든인자), 디폴드생성자
	//getter and setter
	//toString
	
	public Student(String userid, String password, String name) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [userid=" + userid + ", password=" + password + ", name=" + name + "]";
	}
	

	
	
}

public class C06TxMain {
	//DB Conn Data
	final static String id = "root";
	final static String pw = "1234";
	final static String url = "jdbc:mysql://localhost:3306/testDB";
	
	//JDBC 참조변수
	static Connection conn = null;				//DBMS 의 특정 DB연결을 위한 참조변수
	static PreparedStatement pstmt = null;		//SQL 쿼리 전송용 참조변수
	static ResultSet rs = null;					//SQL 쿼리중 조회결과(ex. SELECT) 수신용 참조변수
	
	
	
	public static boolean Insert(Student student) throws Exception{
		return false;
	}
	public static boolean Insert(List<Student> list) throws Exception{
		conn.setAutoCommit(false);
		for(Student student : list) {
			pstmt = conn.prepareStatement("insert into tbl_std values(?,?,?)");
			pstmt.setString(1, student.getUserid());
			pstmt.setString(2, student.getPassword());
			pstmt.setString(3, student.getName());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("INSERT 성공");
			}
			else {
				System.out.println("INSERT 실패");
			}		
		}
		conn.commit();
		return true;
	}	
	
	public static boolean Init() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver"); //드라이브 파일을 메모리공간에 적재
		System.out.println("Driver Loading Success..");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("DB Connected..");
		return true;
	}
	
	public static void main(String[] args) {
		List<Student> list = new ArrayList();
		list.add(new Student("aaa","111","a"));
		list.add(new Student("bbb","222","b"));
		list.add(new Student("aaa","333","c"));
		
		try {
			Init();
			Insert(list);
		
		} catch (Exception e) {
			
			try {
				System.out.println("예외발생! " + e);
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//			e.printStackTrace();
			
		}
		
	}
}



