package Ch36.Domain.Service;

import java.util.List;

import Ch36.Domain.Dao.BookDaoImpl;
import Ch36.Domain.Dao.UserDaoImpl;
import Ch36.Domain.Dto.BookDto;

public class BookServiceImpl {
	
	private BookDaoImpl dao;
	
	
	private static BookServiceImpl instance ;
	public static BookServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance=new BookServiceImpl();
		return instance;
	}
	
	private BookServiceImpl() throws Exception{
		dao = BookDaoImpl.getInstance();
	}
	
	public boolean bookRegister(BookDto dto) throws Exception {;
		return dao.Insert(dto);
	};
	public List<BookDto> getAllBooks() throws Exception {
		return dao.SelectAll();
	}
	public BookDto getBook(int bookCode) throws Exception{
		return dao.Select(bookCode);
	}

}
