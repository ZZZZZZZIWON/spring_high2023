package kr.ac.kopo.shopbooking.dao;

import java.util.List;

import kr.ac.kopo.shopbooking.model.Shop;

public interface ShopDao {

	List<Shop> list();

	void add(Shop item);

	Shop item(Long tableId);

	void update(Shop item);

	void delete(Long tableId);

}
