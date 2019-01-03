package com.zazpi.nozama.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zazpi.nozama.model.Order;

@Transactional
public interface OrdersDao extends CrudRepository<Order,Long>{

}
