package com.zazpi.nozama.controller;

import java.util.HashMap;
import java.util.List;

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

import com.zazpi.nozama.dao.ProductStackDao;
import com.zazpi.nozama.dao.ShelfDao;
import com.zazpi.nozama.model.ProductModel;
import com.zazpi.nozama.model.ProductStack;
import com.zazpi.nozama.model.rest.WarehouseProductStockRest;
import com.zazpi.nozama.model.rest.WordCloudRest;

@Controller
@RequestMapping("/api/stock")
public class StockController {
	@Autowired
	ProductStackDao stackDao;
	@Autowired
	ShelfDao shelfDao;
	
	@PostMapping("add")
	public String newProduct(@Valid @ModelAttribute("productstack")ProductStack productstack, 
			BindingResult result, ModelMap model) {
		stackDao.save(productstack);
		return "redirect:/productList";
  }
	@GetMapping("get")
	public @ResponseBody int getStock (@RequestParam("productId") int id) {	
		int stock = 0;
		for(ProductStack ps : stackDao.findByModelId(id))
			stock += ps.getStock();
		return stock;		
	}
	
	@GetMapping("getwarehousestock")
	public @ResponseBody HashMap<String, Integer> getWarehouseStock (@RequestParam("productId") int id) {	
		HashMap<String,Integer> map = new HashMap<>();
		for(ProductStack ps : stackDao.findByModelId(id))
			map.put(ps.getShelf().getWarehouse().getName(), ps.getStock());
		return map;		
	}
	
	@GetMapping("getproductwarehousestock")
	public @ResponseBody List<WarehouseProductStockRest> getWarehouseStock1 (@RequestParam("productId") int id) {	
		return stackDao.getProductWarehouseStock(id);		
	}
	
	@GetMapping("getwordcloud")
	public @ResponseBody List<WordCloudRest> getWordCloud (){
		return stackDao.getWordCloud();
	}
	
	@GetMapping("getcapacity")
	public @ResponseBody long getCapacity(@RequestParam("warehouseId") int warehouseid) {
		if(warehouseid == 0)
			return stackDao.getOccupedSpace() * 100 / (shelfDao.getCapacity()*100000000000L);
		else
			return stackDao.getOccupedSpaceByWarehouse(warehouseid) * 100 / (shelfDao.getCapacityByWarehouse(warehouseid)*100000000000L);
	}
	
}
