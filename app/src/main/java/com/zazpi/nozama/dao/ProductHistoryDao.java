package com.zazpi.nozama.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.ProductStack;

@Transactional
public interface ProductHistoryDao extends CrudRepository<ProductStack,Long>{
	
	@Modifying
	@Query(value="insert into productstackhistory(warehouseid, productmodelid,stock,startdate)"
			+ "values(?1,?2,?3,?4)"
			,nativeQuery=true)
	public void nativeSave(int warehouseid, int productmodelid,int stock, Date date);
}
