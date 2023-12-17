package kr.ac.kopo.shopbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.shopbooking.dao.TimeTableDao;
import kr.ac.kopo.shopbooking.model.TimeTable;

@Service
public class TimeTableServiceImpl implements TimeTableService {
	
	@Autowired
	TimeTableDao dao;

	@Override
	public List<TimeTable> list() {
		return dao.list();
	}

	@Override
	public void add(TimeTable item) {
		dao.add(item);
	}

	@Override
	public TimeTable item(Long timeId) {
		return dao.item(timeId);
	}

	@Override
	public void update(TimeTable item) {
		dao.update(item);
	}

	@Override
	public void delete(Long timeId) {
		dao.delete(timeId);
	}

	
}
