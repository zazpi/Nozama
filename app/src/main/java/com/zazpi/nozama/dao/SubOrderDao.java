package com.zazpi.nozama.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.SubOrder;
import com.zazpi.nozama.model.rest.SubOrderProductRest;

@Transactional
public interface SubOrderDao extends CrudRepository<SubOrder,Long>{
	@Query (value="select so.suborderid, pm.productmodelid, pm.name, so.departuredate,op.ready, w.name as origin "
	+ "from suborders so join ordersproducts op on so.suborderid = op.suborderid "
	+ "join productmodel pm on pm.productmodelid = op.productmodelid "
	+ "join warehouse w on w.warehouseid = so.origin "
	+ "where so.orderid=? "
	+ "order by so.orderid"
	,nativeQuery=true)
	List<SubOrderProductRest> findByOrderId(int id);
	
	@Modifying
	@Query(value="update ordersproducts set ready=true where productmodelid=?2 and suborderid=?1",
			nativeQuery=true)
	void updateReady(int suborderid, int productmodelid);
	
	@Query(value="select bool_and(ready) from ordersproducts where suborderid=?",
			nativeQuery=true)
	boolean allReady(int suborderid);
	
	@Modifying
	@Query(value="update suborders set departuredate=?2 where suborderid=?1",
			nativeQuery=true)
	void updateSubOrderDepartureDate(int suborderid, Date date);
}
