package Ch36.Controller;

import java.util.Map;

public class UserController implements SubController{
	
	// 1 Insert , 2 Update , 3 Delete 4 SelectAll 5 Select 6 Login 7 Logout 
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("UserController's execute()");
		if(serviceNo==1) {
			
		}else if(serviceNo==2) {
			
		}else if(serviceNo==3) {
			
		}else if(serviceNo==4) {
			
		}else if(serviceNo==5) {
			
		}else if(serviceNo==6) {
			
		}else if(serviceNo==7) {
			
		}else {
			;
		}
		return null;
	}

}
