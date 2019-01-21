package com.zazpi.nozama.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
import com.zazpi.nozama.dao.ProductStackDao;
import com.zazpi.nozama.dao.SubOrderDao;
import com.zazpi.nozama.dao.WarehouseDao;
import com.zazpi.nozama.model.Order;
import com.zazpi.nozama.model.ProductModel;
import com.zazpi.nozama.model.SubOrder;
import com.zazpi.nozama.model.Warehouse;
import com.zazpi.nozama.model.rest.OrderRest;
import com.zazpi.nozama.model.rest.SubOrderProductRest;
import com.zazpi.nozama.util.Util;
import com.zazpi.nozama.util.WarehouseComparator;

@Controller
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	OrdersDao ordersDao;

	@Autowired
	ProductModelDAO productDao;

	@Autowired
	WarehouseDao warehouseDao;

	@Autowired
	SubOrderDao subOrderDao;
	
	@Autowired
	ProductStackDao stackDao;

	@GetMapping("new")
	public @ResponseBody Order newOrder (@RequestParam("destination") int destination,
                                           @RequestParam("products")  List<Integer> products) {
		Set<ProductModel> prs = constructProducts(products);
		HashMap<Warehouse,Set<ProductModel>> selectedWarehouses = selectBestWarehouses(prs,destination);

		Order order = new Order();
		order.setDestination(destination);
		order.setEntryDate(new Date());

		Set<SubOrder> suborders = new HashSet<>();
		for(Warehouse wh : selectedWarehouses.keySet()) {
			SubOrder suborder = new SubOrder();
			suborder.setProducts(selectedWarehouses.get(wh));
			suborder.setOrigin(wh);
			suborder.setOrder(order);
			suborders.add(suborder);
		}
		order.setSuborders(suborders);

		ordersDao.save(order);
		getRequest(suborders);
		return order;
	}
	
	public void getRequest (Set<SubOrder> suborders) {
		
		for (SubOrder s : suborders) {
			int id = s.getId();
			String shelfsList = "";
			String productsList = "";
			Set<ProductModel> set = s.getProducts();
			List<ProductModel> products = new ArrayList<>();
			products.addAll(set);
			for(int i = 0 ; i < products.size();i++ ) {
				ProductModel pm = products.get(i);
				int shelfId = stackDao.getId(pm.getId(),s.getOrigin().getId());
				stackDao.updateStock(pm.getId(),s.getOrigin().getId());
				if(i != 0) {
					shelfsList +=  ",";
					productsList += ",";
				}				
				shelfsList += shelfId;
				System.out.println(pm.getId());
				productsList += pm.getId();
			}
			String parameters = "suborder=" + id +
					"&shelfs=" + shelfsList +
					"&products=" + productsList;
			URL url;
			try {
				url = new URL("http://simulator:4567/neworder?" + parameters);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.getResponseCode();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public HashMap<Warehouse,Set<ProductModel>> selectBestWarehouses(Set<ProductModel> products, int destination){
		HashMap<Warehouse,Set<ProductModel>> bestWarehouses = new HashMap<>();
		for(ProductModel p : products) {
			List<Warehouse> warehouses = warehouseDao.findByProductModel(p.getId());
			Collections.sort(warehouses, WarehouseComparator.getDistanceComparator(p.getId(), destination));
			if(!warehouses.isEmpty())
				addToHashList(bestWarehouses,warehouses.get(0),p);
		}
		return bestWarehouses;
	}

	public void addToHashList(HashMap<Warehouse,Set<ProductModel>> map,Warehouse warehouse, ProductModel product) {
		Set<ProductModel> list = map.get(warehouse);
		if(list == null)
			list = new HashSet<>();
		list.add(product);
		map.put(warehouse,list);
	}

	@GetMapping("list")
	public @ResponseBody List<OrderRest> getOrderList(){
		return (List<OrderRest>) ordersDao.findAllRest();
	}

	@GetMapping("list-location")
	public @ResponseBody List<Object[]> getOrdersByPlace(){
		List<Object[]> list = ordersDao.getOrdersByPlace();
		return Util.prepareCodes(list);
	}

	@GetMapping("list-location-product")
	public @ResponseBody List<Object[]> getOrdersByPlaceAndProduct(@RequestParam("productId") int id){
		List<Object[]> list = ordersDao.getOrdersByPlaceAndProduct(id);
		return Util.prepareCodes(list);
	}

	@GetMapping("list-day-month")
	public @ResponseBody List<Object[]> groupedByDayMonth(){
		return ordersDao.groupedByDayMonth();
	}

	@GetMapping("subOrderList")
	public @ResponseBody List<SubOrderProductRest> getSubOrderProductList(@RequestParam("orderId") int id){
		return (List<SubOrderProductRest>) subOrderDao.findByOrderId(id);
	}

	@GetMapping("updateSuborder")
	public @ResponseBody boolean updateSuborder(@RequestParam("productId") int pi,
			                                    @RequestParam("subOrderId") int si){
		subOrderDao.updateReady(si, pi);
		boolean ready = subOrderDao.allReady(si);
		if(ready) {
			subOrderDao.updateSubOrderDepartureDate(si,new Date());
		}
		return ready;
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
