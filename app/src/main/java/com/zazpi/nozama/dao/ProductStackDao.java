package com.zazpi.nozama.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.ProductStack;

@Transactional
public interface ProductStackDao extends CrudRepository<ProductStack,Long> {
	Set<ProductStack> findByModelId(int id);
	
	@Query(value = "SELECT sum(stock) from productstack where productmodelid = ?1", nativeQuery = true)
	Integer getSumStock(int modelid);
	
}
