package com.zazpi.nozama.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.zazpi.nozama.model.ProductModel;

@Transactional
public interface ProductModelDAO extends CrudRepository<ProductModel,Long> {
	List<ProductModel> findByName(String name);
}
