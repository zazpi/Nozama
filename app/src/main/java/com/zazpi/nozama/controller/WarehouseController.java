package com.zazpi.nozama.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zazpi.nozama.dao.ProductModelDAO;
import com.zazpi.nozama.dao.WarehouseDao;
import com.zazpi.nozama.model.ProductModel;
import com.zazpi.nozama.model.Warehouse;

@Controller
@RequestMapping("/api")
public class WarehouseController {
	@Autowired
	WarehouseDao warehouseDao;
	
	@Autowired
	ProductModelDAO productModelDao;
	
	@GetMapping("warehouse")
	public @ResponseBody List<Warehouse> getWarehouses () {		
		return (List<Warehouse>) warehouseDao.findAll();		
	}
	
	@GetMapping("products")
	public @ResponseBody List<ProductModel> getProductModels () {
		return (List<ProductModel>) productModelDao.findAll();
	}
}
