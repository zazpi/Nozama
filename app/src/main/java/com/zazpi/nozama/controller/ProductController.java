package com.zazpi.nozama.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zazpi.nozama.dao.ProductModelDAO;
import com.zazpi.nozama.dao.ProductStackDao;
import com.zazpi.nozama.model.ProductModel;

@Controller
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductModelDAO productModelDao;
	
	@Autowired
	ProductStackDao productStackDao;
	
	@GetMapping("list")
	public @ResponseBody List<Object[]> getProductModels () {
		List<Object[]> list =  productModelDao.getModelsAndStock();
			
		return list;
	}
	
	@GetMapping("get")
	public @ResponseBody Optional<ProductModel> getProduct (@RequestParam("productId") int id) {
		return (productModelDao.findById(id));
	}
	
    @PostMapping(value = "new")
    public String newProduct(@Valid @ModelAttribute("productmodel")ProductModel productmodel, 
    	      BindingResult result, ModelMap model) {
    	productModelDao.save(productmodel);
    	return "redirect:/productList";
    }
    
}
