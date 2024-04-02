package Ch37_MVC_Add_View_Socket_Thread.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch36.Domain.Dto.BookDto;
import Ch36.Domain.Service.BookServiceImpl;

public class BookController implements SubController{
	
	private BookServiceImpl service;
	public BookController(){	
		try {
			
			service = new BookServiceImpl();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 1 Insert , 2 Update , 3 Delete 4 SelectAll 5 Select 
	
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("BookController's execute()");
		//1 파라미터 받기
		//2 입력값 검증(유효성체크(데이터) ,Validation Check)
		//3 서비스 실행
		//4 뷰페이지로 이동(or Rest Data 전달)
		
		
		return null;
	}

	
	private boolean isValid(BookDto dto) {
		// Null체크
		// trim제거
		
		return true;
	}
	
}
