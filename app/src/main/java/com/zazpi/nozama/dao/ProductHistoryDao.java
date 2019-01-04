package com.zazpi.nozama.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.ProductHistory;

@Transactional
public interface ProductHistoryDao extends CrudRepository<ProductHistory,Long>{

}
