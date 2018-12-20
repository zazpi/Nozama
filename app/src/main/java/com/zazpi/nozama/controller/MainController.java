package com.zazpi.nozama.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zazpi.nozama.dao.ProductModelDAO;
import com.zazpi.nozama.dao.ProductStackDao;
import com.zazpi.nozama.model.ProductModel;

@Controller
public class MainController {
	
	@Autowired
	ProductModelDAO productDao;
	
	@Autowired
	ProductStackDao stackDao;
	
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String home() {
        return "site.welcome";
    }
    
    @RequestMapping(value = "/crud", method={ RequestMethod.GET, RequestMethod.POST })
    public String crud(Model model) {
    	model.addAttribute("productmodel", new ProductModel());
    	model.addAttribute("products",productDao.findAll());
    	return "site.crud";
    }
    
    @RequestMapping(value = "/processForm", method=RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("productmodel")ProductModel productmodel, 
    	      BindingResult result, ModelMap model) {
        productDao.save(productmodel);
        return new ModelAndView("redirect:/crud", model);
    }
    
    @RequestMapping(value="/admin")
    public String admin() {
    	return "site.admin";
    }
    
    @RequestMapping(value="/forbidden")
    public String forbidden() {
    	return "site.forbidden";
    }
}
