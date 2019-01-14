package com.zazpi.nozama.model.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

public interface OrderRest {
	@Value("#{target.orderid}")
	int getId();
	
	int getDestination();
	
	Date getEntryDate();
	
}
