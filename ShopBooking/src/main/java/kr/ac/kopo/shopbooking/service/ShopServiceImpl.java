package kr.ac.kopo.shopbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.shopbooking.dao.ShopDao;
import kr.ac.kopo.shopbooking.model.Shop;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	ShopDao dao;

	@Override
	public List<Shop> list() {
		return dao.list();
	}

	@Override
	public void add(Shop item) {
		dao.add(item);
	}

	@Override
	public Shop item(Long tableId) {
		return dao.item(tableId);
	}

	@Override
	public void update(Shop item) {
		dao.update(item);
	}

	@Override
	public void delete(Long tableId) {
		dao.delete(tableId);
	}

}
