package com.zazpi.nozama.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.ProductStack;
import com.zazpi.nozama.model.rest.WarehouseStockRest;

@Transactional
public interface ProductStackDao extends CrudRepository<ProductStack,Long> {
	Set<ProductStack> findByModelId(int id);
	List<ProductStack> findAll();
	
	@Query(value = "SELECT sum(stock) from productstack where productmodelid = ?1", nativeQuery = true)
	Integer getSumStock(int modelid);
	
	@Query(value= "select warehouseid, productmodelid, sum(stock) as stock"
			+ " from productstack "
			+ "group by productmodelid,warehouseid"
			,nativeQuery=true)
	List<WarehouseStockRest> getWarehouseStock();
	
}
