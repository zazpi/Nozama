package com.zazpi.nozama.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.Order;
import com.zazpi.nozama.model.rest.OrderRest;

@Transactional
public interface OrdersDao extends CrudRepository<Order,Long>{
	@Query(value="select destination/1000 as cp, count(orderid) as total "
			+ "from orders "
			+ "group by cp "
			,nativeQuery=true)
	List<Object[]> getOrdersByPlace();
	
	@Modifying
	@Query(value="select o.destination/1000 as cp, sum(so.suborderid) as total "
			+ "from (orders as o join suborders as so on o.orderid = so.orderid "
			+ "join ordersproducts as op on op.suborderid = so.suborderid) "
			+ "where op.productmodelid=?1 "
			+ "group by cp "
			,nativeQuery=true)
	List<Object[]> getOrdersByPlaceAndProduct(int productid);
	
	@Query(value="select orderid, destination, entrydate from orders "
			,nativeQuery=true)
	List<OrderRest> findAllRest();
}
