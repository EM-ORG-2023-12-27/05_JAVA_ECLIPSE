package Ch36;

import Ch36.Domain.Dao.BookDaoImpl;
import Ch36.Domain.Dto.BookDto;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
		//01
//		FrontController frontController =  new FrontController();
//		Map<String,Object> params= new HashMap();
//		params.put("bookDto",new BookDto(1111,"JAVA의정석","EASY","111-111"));
//		frontController.execute("/book", 1, params);
//		System.out.println();
		
		//02
		BookDaoImpl dao = new BookDaoImpl();
		dao.Insert(new BookDto(1111,"JAVA의정석","EASY","111-111"));
		
		
		
		
		
	}
	
	
}
