package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;

public interface BookService {

	List<Book> list(Pager pager);

	void add(Book item);

	Book item(Long bookid);

	void update(Book item);

	void delete(Long bookid);

	void dummy();

	void init();

}
