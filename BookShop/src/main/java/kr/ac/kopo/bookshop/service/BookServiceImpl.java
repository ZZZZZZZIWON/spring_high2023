package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.BookDao;
import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;

	@Override
	public List<Book> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Book item) {
		dao.add(item);
	}

	@Override
	public Book item(Long bookid) {
		return dao.item(bookid);
	}

	@Override
	public void update(Book item) {
		dao.update(item);
	}

	@Override
	public void delete(Long bookid) {
		dao.delete(bookid);
	}

	@Override
	public void dummy() {
		for (int i = 11; i < 100; i++) {
			Book item = new Book();

			item.setBookid((long) i);
			item.setBookname("도서명" + i);
			item.setPublisher("출판사" + i);
			item.setPrice((long) i * 1000);

			dao.add(item);
		}
	}

	@Override
	public void init() {
		for(int i=11; i <100; i++)
			dao.delete((long) i);
	}

	
}
