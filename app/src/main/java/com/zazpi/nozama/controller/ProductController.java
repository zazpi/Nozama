package com.zazpi.nozama.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zazpi.nozama.dao.ProductModelDAO;
import com.zazpi.nozama.model.ProductModel;

@Controller
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductModelDAO productModelDao;
	
	@GetMapping("list")
	public @ResponseBody List<ProductModel> getProductModels () {
		return (List<ProductModel>) productModelDao.findAll();
	}
	
	@GetMapping("get")
	public @ResponseBody Optional<ProductModel> getProduct (@RequestParam("productId") int id) {
		return (productModelDao.findById(id));
	}
}
