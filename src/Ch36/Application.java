package Ch36;

import java.util.HashMap;
import java.util.Map;

import Ch36.Controller.FrontController;
import Ch36.Domain.Dto.BookDto;

public class Application {

	
	public static void main(String[] args) throws Exception {
		
		//01
//		FrontController frontController =  new FrontController();
//		Map<String,Object> params= new HashMap();
//		params.put("bookDto",new BookDto(1111,"JAVA의정석","EASY","111-111"));
//		frontController.execute("/book", 1, params);
//		System.out.println();
		
		//02
//		BookDaoImpl dao = new BookDaoImpl();
//		dao.Insert(new BookDto(1112,"JAVA의정석-2","EASY","111-112"));
//		dao.Insert(new BookDto(1113,"난정말JAVA를공부해본적이없다구요","00출판사","211-111"));
//		dao.Insert(new BookDto(1114,"JSP/SERVLET 기초","ㅋㅋ출판사","112-111"));
		
		//03
//		List<BookDto> list =  dao.SelectAll();
//		list.forEach(dto->{
//			System.out.println(dto);
//		});
//		System.out.println();
//		BookDto dto =  dao.Select(1112);
//		System.out.println(dto);
		
		//04
//		BookServiceImpl service = new BookServiceImpl();
//		List<BookDto> list =  service.getAllBooks();
//		list.forEach(dto->{
//			System.out.println(dto);
//		});
		
		//05
		FrontController controller = new FrontController();
		Map<String,Object> params = new HashMap();
		params.put("bookDto",new BookDto(2222,"이것이C언어다","EASY","222-2222"));
		Map<String,Object> result =   controller.execute("/book", 1, params);
		Object response = result.get("response");
		

		
	}
	
	
}
