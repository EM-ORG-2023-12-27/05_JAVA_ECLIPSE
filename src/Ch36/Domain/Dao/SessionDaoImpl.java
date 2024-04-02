package Ch36.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Ch36.Domain.Dto.SessionDto;

public class SessionDaoImpl {
	private String url ="jdbc:mysql://localhost:3306/bookdb";
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn =null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public SessionDaoImpl() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("[DAO] SessionDaoImpl's INIT DB Connected...");
	}
	
	//SESSION용
	public boolean Insert(SessionDto sessionDto) throws Exception {
		pstmt =  conn.prepareStatement("insert into session values(null,?,?)");
		pstmt.setString(1, sessionDto.getUsername());
		pstmt.setString(2, sessionDto.getRole());
		return pstmt.executeUpdate()>0;
	}
	
	public SessionDto Select(int sessiondId) throws Exception {
		pstmt = conn.prepareStatement("select * from session where id=?");
		pstmt.setInt(1,sessiondId);
		rs=pstmt.executeQuery();
		SessionDto dto=null;
		if(rs!=null) {
			rs.next();
			dto=new SessionDto();
			dto.setUsername(rs.getString("username"));
			dto.setRole(rs.getString("role"));
			dto.setSessionId(rs.getInt("id"));
		}
			
		return dto;
	}
	public SessionDto Select(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from session where username=?");
		pstmt.setString(1,username);
		rs=pstmt.executeQuery();
		SessionDto dto=null;
		if(rs!=null) {
			rs.next();
			dto=new SessionDto();
			dto.setUsername(rs.getString("username"));
			dto.setRole(rs.getString("role"));
			dto.setSessionId(rs.getInt("id"));
		}
			
		return dto;
	}
	
	
}
