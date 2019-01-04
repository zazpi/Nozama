package com.zazpi.nozama;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zazpi.nozama.dao.ProductModelDAO;
import com.zazpi.nozama.dao.ProductStackDao;
import com.zazpi.nozama.model.ProductModel;
import com.zazpi.nozama.model.ProductStack;
import com.zazpi.nozama.model.Shelf;
import com.zazpi.nozama.model.Warehouse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateTest {
	
	@Autowired
	ProductModelDAO productDao;
	
	@Autowired
	ProductStackDao stackDao;
	
	@Test
	@Transactional
	public void insertTest() {
		ProductModel pm = new ProductModel("TestName","TestDescription",10,1,2,3);
		long nBefore = productDao.count();
		productDao.save(pm);
		long nAfter = productDao.count();
		assertEquals(nBefore+1,nAfter);
	}
	
	@Test
	@Transactional
	public void deleteTest() {
		ProductModel pm = new ProductModel("TestName","TestDescription",10,1,2,3);
		long nBefore = productDao.count();
		productDao.save(pm);
		productDao.delete(pm);
		long nAfter = productDao.count();
		assertEquals(nBefore,nAfter);
	}
	
	@Test
	@Transactional
	public void testCustom() {
		ProductModel pm = new ProductModel("TestName2","TestDescription",10,1,2,3);
		productDao.save(pm);
		List<ProductModel> prs = productDao.findByName("TestName2");
		assertEquals(1,prs.size());
	}
	
	@Ignore
	@Test
	@Transactional
	public void testProductStack() {
		ProductModel pm = new ProductModel("TestName2","TestDescription",10,1,2,3);
		Warehouse w = new Warehouse("Izena",20500);
		Shelf sh = new Shelf(5,4,w);
		ProductStack ps = new ProductStack(2,pm,sh);
		stackDao.save(ps);
		assertEquals(1,stackDao.count());
	}

}
