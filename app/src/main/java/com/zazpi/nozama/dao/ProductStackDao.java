package com.zazpi.nozama.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.ProductStack;
import com.zazpi.nozama.model.rest.WarehouseProductStockRest;
import com.zazpi.nozama.model.rest.WarehouseStockRest;
import com.zazpi.nozama.model.rest.WordCloudRest;

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
	
	@Query(value= "select wh.name, sum(ps.stock) as stock"
			+ " from productstack as ps join warehouse as wh on ps.warehouseid = wh.warehouseid "
			+ "where ps.productmodelid = ?1 "
			+ "group by wh.warehouseid"
			,nativeQuery=true)
	List<WarehouseProductStockRest> getProductWarehouseStock(int id);
	
	@Query(value= "select pm.name, sum(ps.stock) as stock"
			+ " from productstack as ps join productmodel pm on ps.productmodelid = pm.productmodelid "
			+ "group by pm.productmodelid"
			,nativeQuery=true)
	List<WordCloudRest> getWordCloud();
	
	@Query(value= "select sum(q.size) "
			+ "from (select (pm.x*pm.y*pm.z)*sum(ps.stock) as size from productmodel pm join productstack ps on pm.productmodelid = ps.productmodelid "
			+ "group by pm.productmodelid) q;",
			nativeQuery=true)
	long getOccupedSpace();
	
	@Query(value= "select sum(q.size) "
			+ "from (select (pm.x*pm.y*pm.z)*sum(ps.stock) as size from productmodel pm join productstack ps on pm.productmodelid = ps.productmodelid "
			+ "where ps.warehouseID=? "
			+ "group by pm.productmodelid) q;",
			nativeQuery=true)
	long getOccupedSpaceByWarehouse(int wh);
}
