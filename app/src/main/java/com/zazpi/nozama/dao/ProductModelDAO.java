package com.zazpi.nozama.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.ProductModel;
import com.zazpi.nozama.model.rest.copy.ProductRest;

@Transactional
public interface ProductModelDAO extends CrudRepository<ProductModel,Long> {
	List<ProductModel> findByName(String name);
	Optional<ProductModel> findById(int id);
	@Query(value="select pm.*, coalesce(sum(stock),0) as stock "
			+ "from (productstack ps right join productmodel pm on ps.productmodelid=pm.productmodelid)"
			+ "group by pm.productmodelid "
			+ "order by pm.productmodelid"
			,nativeQuery=true)
	List<ProductRest> getModelsAndStock();
}
