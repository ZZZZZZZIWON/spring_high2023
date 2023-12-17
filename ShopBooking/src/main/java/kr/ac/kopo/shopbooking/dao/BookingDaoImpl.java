package kr.ac.kopo.shopbooking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.shopbooking.model.Booking;
import kr.ac.kopo.shopbooking.pager.Pager;

@Repository
public class BookingDaoImpl implements BookingDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Booking> list(Pager pager) {
		return sql.selectList("booking.list", pager);
	}

	@Override
	public void add(Booking item) {
		sql.insert("booking.add", item);
	}

	@Override
	public Booking item(Long bookingId) {
		return sql.selectOne("booking.item", bookingId);
	}

	@Override
	public void update(Booking item) {
		sql.update("booking.update", item);
	}

	@Override
	public void delete(Long bookingId) {
		sql.delete("booking.delete", bookingId);
	}

}
