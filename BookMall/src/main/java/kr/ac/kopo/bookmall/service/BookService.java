package kr.ac.kopo.bookmall.service;

import java.util.List;

import kr.ac.kopo.bookmall.model.Book;
import kr.ac.kopo.bookmall.pager.Pager;

public interface BookService {

	List<Book> list(Pager pager);

	void add(Book item);

	Book item(Long bookid);

	void update(Book item);

	void delete(Long bookid);

	void dummy();

	void init();

}
