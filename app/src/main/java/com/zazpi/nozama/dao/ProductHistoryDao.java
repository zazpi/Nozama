package com.zazpi.nozama.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.ProductHistory;

@Transactional
public interface ProductHistoryDao extends CrudRepository<ProductHistory,Long>{
	@Modifying
	@Query(value="insert into productstackhistory(warehouseid, productmodelid,stock,startdate)"
			+ "values(?1,?2,?3,?4)"
			,nativeQuery=true)
	void nativeSave(int warehouseid, int productmodelid,int stock, Date date);
	
	Set<ProductHistory> findByModelId(int id);
	
	@Query (value="select extract (epoch from startdate at time zone 'utc')*1000 as startdate, sum(stock) "
			+ "from productstackhistory "
			+ "where productmodelid=?1 "
			+ "group by startdate "
			+ "order by startdate"
			,nativeQuery=true)
	List<Object[]> findByModelIdRaw(int id);

	@Query (value="select extract (epoch from startdate at time zone 'utc')*1000 as startdate, sum(stock) "
			+ "from productstackhistory "
			+ "where productmodelid=?1 and warehouseid=?2 "
			+ "group by startdate "
			+ "order by startdate"
			,nativeQuery=true)
	List<Object[]> findByModelIdRaw(int product, int wId);
}
