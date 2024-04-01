package Ch36.Controller;

import java.util.Map;

import Ch36.Domain.Dto.BookDto;

public class BookController implements SubController{
	// 1 Insert , 2 Update , 3 Delete 4 SelectAll 5 Select 
	
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("BookController's execute()");
		//1 파라미터 받기
		//2 입력값 검증(유효성체크(데이터) ,Validation Check)
		//3 서비스 실행
		//4 뷰페이지로 이동(or Rest Data 전달)
		
		if(serviceNo==1) 	//INSERT
		{
			
			//1
			BookDto dto =(BookDto)params.get("bookDto");
			System.out.println("[SC]BookController's Insert.."+dto);
			
			//2
			if( !isValid(dto) ) 
				return null;
			
			//3 서비스 실행
			
			//4 뷰로 전달 or 이동
			
		}
		else if(serviceNo==2) //UPDATE
		{
			System.out.println("");
		}
		else if(serviceNo==3) //DELETE
		{
			System.out.println("");
		}
		else if(serviceNo==4) //SELECTALL
		{
			System.out.println("");
		}
		else if(serviceNo==5) //SELECTONE
		{
			System.out.println("");
		}
		else
		{
			System.out.println("");
		}

		
	
		return null;
	}

	
	private boolean isValid(BookDto dto) {
		// Null체크
		// trim제거
		
		return true;
	}
	
}
