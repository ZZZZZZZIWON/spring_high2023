package kr.ac.kopo.shopbooking.dao;

import java.util.List;

import kr.ac.kopo.shopbooking.model.Member;

public interface MemberDao {

	List<Member> list();

	void add(Member item);

	Member item(String id);

	void update(Member item);

	void delete(String id);

	Member login(Member item);

}
