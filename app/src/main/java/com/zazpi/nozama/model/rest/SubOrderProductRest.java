package com.zazpi.nozama.model.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

public interface SubOrderProductRest {

	@Value("#{target.suborderid}")
	int getSubOrderId();
	int getProductModelId();
	String getName();
	boolean getReady();
	String getOrigin();
	Date getDepartureDate();
}
