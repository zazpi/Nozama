package com.zazpi.nozama.model.rest;

import org.springframework.beans.factory.annotation.Value;

public interface WarehouseStockRest {
	@Value("#{target.warehouseid}")
	int getWarehouseId();
	
	@Value("#{target.productmodelid}")
	int getProductModelId();
	
	@Value("#{target.stock}")
	int getStock();
	
}
