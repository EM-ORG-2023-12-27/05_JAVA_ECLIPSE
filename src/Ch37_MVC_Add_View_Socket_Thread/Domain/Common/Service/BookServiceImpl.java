package Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Service;

import java.util.List;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao.BookDao;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao.BookDaoImpl;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao.Common.ConnectionPool;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.BookDto;

public class BookServiceImpl implements BookService {
	
	private BookDao dao;
	private ConnectionPool connectionPool; //05-01Day
	
	private static BookService instance ;
	public static BookService getInstance() throws Exception {
		if(instance==null)
			instance=new BookServiceImpl();
		return instance;
	}
	
	private BookServiceImpl() throws Exception{
		
		dao = BookDaoImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
	}
	
	@Override
	public boolean bookRegister(BookDto dto) throws Exception {
		
		//TX
		connectionPool.txStart();			//05-01 Day TX
		boolean result = dao.Insert(dto);	//05-01 Day TX
		connectionPool.txCommit();			//05-01 Day TX
		
		return result;
	};
	@Override
	public List<BookDto> getAllBooks() throws Exception {
		
		//TX
		connectionPool.txStart();				//05-01 Day TX
		List<BookDto> list = dao.SelectAll();	//05-01 Day TX
		connectionPool.txCommit();				//05-01 Day TX
		return list;
	}
	
	
	@Override
	public BookDto getBook(int bookCode) throws Exception{
		
		
		BookDto dto =  dao.Select(bookCode);
		
		return dto;
	}

}
