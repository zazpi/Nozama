package com.zazpi.nozama.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zazpi.nozama.dao.OrdersDao;
import com.zazpi.nozama.dao.ProductModelDAO;
import com.zazpi.nozama.model.Order;
import com.zazpi.nozama.model.ProductModel;
import com.zazpi.nozama.util.Util;

@Controller
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	ProductModelDAO productDao;

	@GetMapping("new")
	public @ResponseBody boolean newOrder (@RequestParam("origin") int origin,
                                           @RequestParam("destination") int destination,
                                           @RequestParam("products")  List<Integer> products) {
		Order order = new Order();
		order.setOrigin(origin);
		order.setDestination(destination);
		order.setEntryDate(new Date());
		order.setProducts(constructProducts(products));
		System.out.println(order);
		ordersDao.save(order);
		return true;		
	}
	
	@GetMapping("list")
	public @ResponseBody List<Order> getOrderList(){
		return (List<Order>) ordersDao.findAll();
	}
	
	@GetMapping("list-location")
	public @ResponseBody List<Object[]> getOrdersByPlace(){
		List<Object[]> list = ordersDao.getOrdersByPlace();
		for(Object[] o : list) {
			int cp = (int) o[0];
			String code = "es-" + Util.CODES[cp - 1];
			o[0] = code;
		}
		return list;
	}
	
	//FIXME: Function should be in a util class
	public Set<ProductModel> constructProducts(List<Integer> products){
		Set<ProductModel> set = new HashSet<>();
		for(Integer p : products) {
			Optional<ProductModel> pm = productDao.findById(p);
			if(pm.isPresent())
				set.add(pm.get());
		}
		return set;
	}
}
