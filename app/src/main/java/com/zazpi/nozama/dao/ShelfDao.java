package com.zazpi.nozama.dao;

import org.springframework.data.repository.CrudRepository;

import com.zazpi.nozama.model.Shelf;

public interface ShelfDao extends CrudRepository<Shelf,Long> {

}
