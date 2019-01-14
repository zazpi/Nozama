package com.zazpi.nozama.model.rest;

import org.springframework.beans.factory.annotation.Value;

public interface WarehouseProductStockRest {
	@Value("#{target.name}")
	String getName();
	
	@Value("#{target.stock}")
	int getY();
	
}