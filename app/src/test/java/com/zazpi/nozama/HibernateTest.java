package com.zazpi.nozama;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zazpi.nozama.dao.ProductModelDAO;
import com.zazpi.nozama.model.ProductModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateTest {
	
	@Autowired
	ProductModelDAO productDao;
	
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

}
