package Ch36.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch36.Domain.Dto.UserDto;
import Ch36.Domain.Service.UserServiceImpl;

public class UserController implements SubController{
	private UserServiceImpl userService;
	
	public UserController(){
		
		try {
			userService=new UserServiceImpl();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	// 1 Insert , 2 Update , 3 Delete 4 SelectAll 5 Select 6 Login 7 Logout 
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("UserController's execute()");
		if(serviceNo==1) {
			
			//01 파라미터
			UserDto dto = (UserDto)params.get("userDto");
			
			//02 유효성
			if(!isValid(dto)) {
				return null;
			}
			//03 서비스
			boolean isJoined=false;
			try {
				isJoined =  userService.UserJoin(dto);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//04 뷰
			Map<String,Object> result = new HashMap();
			result.put("response", isJoined);
			
			
		}else if(serviceNo==2) {
			
		}else if(serviceNo==3) {
			
		}else if(serviceNo==4) {
			
		}else if(serviceNo==5) {
			
		}else if(serviceNo==6) {
			
			// 01 파라미터
			// 02 입력값(Data)
			// 03 서비스
			
			
			// 04 뷰 
			
			
		}else if(serviceNo==7) {
			
		}else {
			;
		}
		return null;
	}
	private boolean isValid(UserDto dto) {
		return true;
	}

}
