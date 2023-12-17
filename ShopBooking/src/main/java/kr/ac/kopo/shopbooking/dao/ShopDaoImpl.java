package kr.ac.kopo.shopbooking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.shopbooking.model.Shop;

@Repository
public class ShopDaoImpl implements ShopDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Shop> list() {
		return sql.selectList("shop.list");
	}

	@Override
	public void add(Shop item) {
		sql.insert("shop.add", item);
	}

	@Override
	public Shop item(Long tableId) {
		return sql.selectOne("shop.item", tableId);
	}

	@Override
	public void update(Shop item) {
		sql.update("shop.update", item);
	}

	@Override
	public void delete(Long tableId) {
		sql.delete("shop.delete", tableId);
	}

}
