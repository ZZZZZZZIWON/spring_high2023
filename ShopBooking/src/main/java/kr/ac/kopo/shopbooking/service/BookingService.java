package kr.ac.kopo.shopbooking.service;

import java.util.List;

import kr.ac.kopo.shopbooking.model.Booking;
import kr.ac.kopo.shopbooking.pager.Pager;

public interface BookingService {

	List<Booking> list(Pager pager);

	void add(Booking item);

	Booking item(Long bookingId);

	void update(Booking item);

	void delete(Long bookingId);

}
