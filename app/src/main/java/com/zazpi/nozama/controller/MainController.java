package com.zazpi.nozama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String home() {
        return "site.welcome";
    }
    
    @RequestMapping(value = "/welcome", method=RequestMethod.GET)
    public ModelAndView welcome() {
    	return new ModelAndView("site.welcome");
    }

    @RequestMapping(value = "/greet/{name}", method=RequestMethod.GET)
    public ModelAndView greetTwoWays(@PathVariable(value="name") final String name, final Model model) {
        return new ModelAndView("site.greeting", "name", name);
    }
}
