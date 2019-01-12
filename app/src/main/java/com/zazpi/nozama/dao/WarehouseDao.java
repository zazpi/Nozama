package com.zazpi.nozama.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.Warehouse;

@Transactional
public interface WarehouseDao extends CrudRepository<Warehouse,Long>{
	@Query(value="select wh.*"
			+ " from ((warehouse wh join shelf sh on wh.warehouseid = sh.warehouseid)"
			+ " join productstack ps on sh.shelfid = ps.shelfid and sh.warehouseid = ps.warehouseid)"
			+ " where ps.productmodelid=?;"
			,nativeQuery=true)
	List<Warehouse> findByProductModel(int productModel);
}
