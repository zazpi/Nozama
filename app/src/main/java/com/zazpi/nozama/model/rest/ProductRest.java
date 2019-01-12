package com.zazpi.nozama.model.rest;

import org.springframework.beans.factory.annotation.Value;

public interface ProductRest {
	@Value("#{target.productmodelid}")
	int getId();
	String getName();
	String getDescription();
	
	@Value("#{target.stock}")
	int getStock();
	
}
