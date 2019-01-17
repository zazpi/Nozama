package com.zazpi.nozama.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zazpi.nozama.model.Shelf;

public interface ShelfDao extends CrudRepository<Shelf,Long> {
	
	@Query
	(value="select sum(capacity) from shelf;",
	nativeQuery=true)
	long getCapacity();
	
	@Query
	(value="select sum(capacity) from shelf where warehouseid=?;",
	nativeQuery=true)
	long getCapacityByWarehouse(int wh);
}
