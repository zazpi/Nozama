package com.zazpi.nozama.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.zazpi.nozama.model.SubOrder;
import com.zazpi.nozama.model.rest.SubOrderProductRest;

@Transactional
public interface SubOrderDao extends CrudRepository<SubOrder,Long>{
	@Query (value="select so.suborderid, pm.productmodelid, pm.name, (so.departuredate is null) as ready, w.name as origin "
	+ "from suborders so join ordersproducts op on so.suborderid = op.suborderid "
	+ "join productmodel pm on pm.productmodelid = op.productmodelid "
	+ "join warehouse w on w.warehouseid = so.origin "
	+ "where so.orderid=?"
	,nativeQuery=true)
	List<SubOrderProductRest> findByOrderId(int id);
}
