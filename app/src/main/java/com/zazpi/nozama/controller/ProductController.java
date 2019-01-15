package com.zazpi.nozama.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.zazpi.nozama.dao.ProductModelDAO;
import com.zazpi.nozama.dao.ProductStackDao;
import com.zazpi.nozama.model.ProductModel;
import com.zazpi.nozama.model.rest.ProductRest;

@Controller
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductModelDAO productModelDao;
	
	@Autowired
	ProductStackDao productStackDao;
	
	@GetMapping("list")
	public @ResponseBody List<ProductRest> getProductModels () {
		List<ProductRest> list =  productModelDao.getModelsAndStock();
			
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

    @PostMapping(value = "update")
	public String updateProduct(@Valid @ModelAttribute("productmodel")ProductModel productModel,
								BindingResult result, ModelMap model){
		productModelDao.save(productModel);
		return "redirect:/productList";
	}

	@PostMapping(value = "preload")
	public String preloadProductData(@RequestBody Map<String, Object> params, HttpServletRequest request) {
		request.setAttribute("product",productModelDao.findById((int) params.get("productId")));
		return "redirect:/editProduct";
	}
    
}
