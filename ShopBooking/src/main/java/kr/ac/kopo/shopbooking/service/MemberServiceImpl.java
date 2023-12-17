package kr.ac.kopo.shopbooking.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.shopbooking.dao.MemberDao;
import kr.ac.kopo.shopbooking.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao dao;

	@Override
	public List<Member> list() {
		return dao.list();
	}

	@Override
	public void add(Member item) {
		dao.add(item);
	}

	@Override
	public Member item(String id) {
		return dao.item(id);
	}

	@Override
	public void update(Member item) {
		dao.update(item);
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public boolean login(Member item) {
		Member result = dao.login(item);
		
		if(result != null) {
			BeanUtils.copyProperties(result, item);
			
			return true;
		}
		
		return false;
	}

}
