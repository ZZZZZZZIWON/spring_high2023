package kr.ac.kopo.shopbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.shopbooking.dao.BookingDao;
import kr.ac.kopo.shopbooking.model.Booking;
import kr.ac.kopo.shopbooking.pager.Pager;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingDao dao;

	@Override
	public List<Booking> list(Pager pager) {
		return dao.list(pager);
	}

	@Override
	public void add(Booking item) {
		dao.add(item);
	}

	@Override
	public Booking item(Long bookingId) {
		return dao.item(bookingId);
	}

	@Override
	public void update(Booking item) {
		dao.update(item);
	}

	@Override
	public void delete(Long bookingId) {
		dao.delete(bookingId);
	}

}
