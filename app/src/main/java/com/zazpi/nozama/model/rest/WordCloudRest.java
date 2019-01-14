package com.zazpi.nozama.model.rest;

import org.springframework.beans.factory.annotation.Value;

public interface WordCloudRest {
	String getName();
	
	@Value("#{target.stock}")
	int getWeight();
}
