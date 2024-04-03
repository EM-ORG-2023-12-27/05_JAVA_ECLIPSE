package Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.UserDto;



public class UserDaoImpl {
	private String url ="jdbc:mysql://localhost:3306/bookdb";
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn =null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public UserDaoImpl() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("[DAO] UserDaoImpl's INIT DB Connected...");
	}
	
	//INSERT
	public boolean Insert(UserDto dto) throws Exception{
		pstmt =  conn.prepareStatement("insert into user values(?,?,?,?)");
		pstmt.setString(1, dto.getUsername());
		pstmt.setString(2, dto.getPassword());
		pstmt.setString(3, dto.getRole());
		pstmt.setBoolean(4, false);
		
		return pstmt.executeUpdate()>0;
	}
	
	//UPDATE
	//DELETE
	//SELECTALL
	//SELECT
	
	

	public UserDto Select(String username) throws Exception{
		pstmt = conn.prepareStatement("select * from user where username=?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		UserDto dto = null;
		
		if(rs!=null) {
			if(rs.next()) {
				dto = new UserDto();
				dto.setUsername(username);
				dto.setPassword(rs.getString("password"));
				dto.setRole(rs.getString("role"));
				dto.setIslocked(rs.getBoolean("islocked"));
			}
			
		}
		return dto;	
	}

	
}
