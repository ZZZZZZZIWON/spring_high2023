package kr.ac.kopo.shopbooking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.shopbooking.model.TimeTable;

@Repository
public class TimeTableDaoImpl implements TimeTableDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<TimeTable> list() {
		return sql.selectList("time_table.list");
	}

	@Override
	public void add(TimeTable item) {
		sql.insert("time_table.add", item);
	}

	@Override
	public TimeTable item(Long timeId) {
		return sql.selectOne("time_table.item", timeId);
	}

	@Override
	public void update(TimeTable item) {
		sql.update("time_table.update", item);
	}

	@Override
	public void delete(Long timeId) {
		sql.delete("time_table.delete", timeId);
	}

}
