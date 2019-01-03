package com.zazpi.nozama.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.Warehouse;

@Transactional
public interface WarehouseDao extends CrudRepository<Warehouse,Long>{

}
