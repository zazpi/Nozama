package com.zazpi.nozama.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zazpi.nozama.dao.ProductHistoryDao;
import com.zazpi.nozama.dao.ProductStackDao;
import com.zazpi.nozama.model.rest.WarehouseStockRest;

@Controller
@RequestMapping("/api/history")
public class HistoryController {
	@Autowired
	ProductStackDao currentDao;
	
	@Autowired
	ProductHistoryDao historyDao;
	
	@GetMapping("update")
	public @ResponseBody boolean updateHistory () {	
		List<WarehouseStockRest> list = currentDao.getWarehouseStock();
		for(WarehouseStockRest wsr : list) { // Not the best way to do it
			historyDao.nativeSave(wsr.getWarehouseId(), wsr.getProductModelId(), wsr.getStock(), new Date());
		}
		return true;
	}
}
