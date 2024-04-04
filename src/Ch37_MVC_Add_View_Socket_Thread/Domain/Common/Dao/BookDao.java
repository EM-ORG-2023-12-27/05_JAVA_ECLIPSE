package Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao;

import java.util.List;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.BookDto;



public interface BookDao {

	//INSERT
	boolean Insert(BookDto dto) throws Exception;

	//SELECTALL
	List<BookDto> SelectAll() throws Exception;

	//SELECTONE
	BookDto Select(int bookCode) throws Exception;

}