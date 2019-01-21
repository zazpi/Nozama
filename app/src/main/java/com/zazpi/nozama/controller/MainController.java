package com.zazpi.nozama.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zazpi.nozama.dao.ProductModelDAO;
import com.zazpi.nozama.dao.WarehouseDao;
import com.zazpi.nozama.model.ProductModel;
import com.zazpi.nozama.model.ProductStack;

@Controller
public class MainController {
    @Autowired
    ProductModelDAO productDao;
    
    @Autowired
	WarehouseDao warehouseDao;

    @GetMapping(value = "/")
    public String home() {
        return "site.welcome";
    }

    @RequestMapping(value = "/orderList")
    public String orderList() {
        return "site.orderList";
    }
    
    @RequestMapping(value = "/orderList/addOrder")
    public String addOrder() {
        return "site.addOrder";
    }

    @RequestMapping(value = "/productList")
    public String productList() {
        return "site.productList";
    }
    
    @RequestMapping(value = "/productList/addStock")
    public String addStock(Model model) {
    	model.addAttribute("productstack", new ProductStack());
    	model.addAttribute("warehouses", warehouseDao.findAll());	
		return "site.addStock";
    }

    @GetMapping(value = "/product")
    public String product(Model model, @RequestParam("productId") int productId) {
        Optional<ProductModel> pr = productDao.findById(productId);
        model.addAttribute("product", pr.get());
        return "site.product";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard() {
        return "site.dashboard";
    }

    @RequestMapping(value = "/productList/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("productmodel", new ProductModel());
        return "site.addProduct";
    }

    @RequestMapping(value = "/forbidden")
    public String forbidden() {
        return "site.forbidden";
    }

    @RequestMapping(value = "/simulator")
    public String simulator() {
        return "site.simulator";
    }
}
