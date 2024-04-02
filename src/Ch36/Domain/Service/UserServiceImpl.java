package Ch36.Domain.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Ch36.Domain.Dao.UserDaoImpl;
import Ch36.Domain.Dto.UserDto;

public class UserServiceImpl {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserDaoImpl userDao;
	public UserServiceImpl() throws Exception {
		System.out.println("UserServiceImpl's UserServiceImpl()");
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		userDao = new UserDaoImpl();
	}
	
	//회원가입
	public boolean UserJoin(UserDto dto) throws Exception {
		//+ 비즈니스 유효성 체크
		//입력패스워드 + re패스워드 일치여부
		//패스워드 정책(정규표현식)
		//현재 상태가 로그인 된 상태인지..
		//..
		//패스워드 암호화
		String encrypt= bCryptPasswordEncoder.encode(dto.getPassword());
		dto.setPassword(encrypt);
		
	 	return userDao.Insert(dto);
	}
	
}
