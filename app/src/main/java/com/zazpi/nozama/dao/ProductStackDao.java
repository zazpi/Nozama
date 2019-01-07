package com.zazpi.nozama.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.ProductStack;

@Transactional
public interface ProductStackDao extends CrudRepository<ProductStack,Long> {
	List<ProductStack> findByModelId(int id);
}
