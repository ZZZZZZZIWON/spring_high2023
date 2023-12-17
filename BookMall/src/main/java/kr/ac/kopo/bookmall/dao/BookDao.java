package kr.ac.kopo.bookmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.kopo.bookmall.model.Book;
import kr.ac.kopo.bookmall.pager.Pager;

@Mapper
public interface BookDao {

	List<Book> list(Pager pager);

	void add(Book item);

	Book item(Long bookid);

	void update(Book item);

	void delete(Long bookid);

	int total(Pager pager);

}
