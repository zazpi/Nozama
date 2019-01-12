package com.zazpi.nozama.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.Order;

@Transactional
public interface OrdersDao extends CrudRepository<Order,Long>{
	@Query(value="select destination/1000 as cp, count(orderid) as total "
			+ "from orders "
			+ "group by cp "
			,nativeQuery=true)
	List<Object[]> getOrdersByPlace();
}
