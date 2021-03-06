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
	
	@Query(value="select o.orderid, o.destination, o.entrydate, bool_and(so.departuredate is not null) as sent "
			+ "from orders as o left join suborders as so on o.orderid = so.orderid "
			+ "group by o.orderid "
			+ "order by o.orderid"
			,nativeQuery=true)
	List<OrderRest> findAllRest();
	
	@Query(value="select (g1.month-1) as month, (g2.day-1) as day, count(o) "
			+ "from generate_series(1,12) as g1(month) cross join generate_series(1,31) as g2(day) "
			+ "left outer join orders as o "
			+ "on extract(month from o.entrydate)=g1.month and extract(day from o.entrydate)=g2.day "
			+ "group by g1.month, g2.day;"
			,nativeQuery=true)
	List<Object[]> groupedByDayMonth();
}
