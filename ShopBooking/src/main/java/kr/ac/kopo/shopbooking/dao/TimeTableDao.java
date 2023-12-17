package kr.ac.kopo.shopbooking.dao;

import java.util.List;

import kr.ac.kopo.shopbooking.model.TimeTable;

public interface TimeTableDao {

	List<TimeTable> list();

	void add(TimeTable item);

	TimeTable item(Long timeId);

	void update(TimeTable item);

	void delete(Long timeId);

}
