package Ch36;

import java.util.HashMap;
import java.util.Map;

import Ch36.Controller.FrontController;
import Ch36.Domain.Dto.BookDto;

public class Main {

	
	public static void main(String[] args) {
		
		FrontController frontController =  new FrontController();
		Map<String,Object> params= new HashMap();
		params.put("bookDto",new BookDto(1111,"JAVA의정석","EASY","111-111"));
		frontController.execute("/book", 1, params);
		System.out.println();
		
		
		
		
	}
	
	
}
