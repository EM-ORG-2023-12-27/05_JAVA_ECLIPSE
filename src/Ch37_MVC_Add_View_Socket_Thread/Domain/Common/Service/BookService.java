package Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Service;



import java.sql.SQLException;
import java.util.List;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.BookDto;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.Criteria;



public interface BookService {

	boolean bookRegister(BookDto dto) throws Exception;

	List<BookDto> getAllBooks() throws Exception;

	BookDto getBook(int bookCode) throws Exception;

	List<BookDto> getAllBooks(Criteria criteria) throws Exception;


}