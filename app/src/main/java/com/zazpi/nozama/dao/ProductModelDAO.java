package com.zazpi.nozama.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.zazpi.nozama.model.ProductModel;

@Transactional
public interface ProductModelDAO extends CrudRepository<ProductModel,Long> {
	List<ProductModel> findByName(String name);
	Optional<ProductModel> findById(int id);
	@Query(value="select pm.*, coalesce(sum(stock),0) as totalstock "
			+ "from (productstack ps right join productmodel pm on ps.productmodelid=pm.productmodelid)"
			+ "group by pm.productmodelid "
			+ "order by pm.productmodelid"
			,nativeQuery=true)
	List<ProductModel> getModelsAndStock();
}
