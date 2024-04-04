package Ch36.Domain.Service;

import java.util.List;

import Ch36.Domain.Dao.BookDao;
import Ch36.Domain.Dao.BookDaoImpl;
import Ch36.Domain.Dao.UserDaoImpl;
import Ch36.Domain.Dto.BookDto;

public class BookServiceImpl implements BookService {
	
	private BookDao dao;
	
	
	
	private static BookService instance ;
	public static BookService getInstance() throws Exception {
		if(instance==null)
			instance=new BookServiceImpl();
		return instance;
	}
	
	private BookServiceImpl() throws Exception{
		
		dao = BookDaoImpl.getInstance();
		
	}
	
	@Override
	public boolean bookRegister(BookDto dto) throws Exception {
		
		//autoCommit false
		
		//commit()
		return dao.Insert(dto);
	};
	@Override
	public List<BookDto> getAllBooks() throws Exception {
		return dao.SelectAll();
	}
	@Override
	public BookDto getBook(int bookCode) throws Exception{
		return dao.Select(bookCode);
	}

}
