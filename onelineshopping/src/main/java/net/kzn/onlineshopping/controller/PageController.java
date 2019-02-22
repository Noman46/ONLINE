package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;

@Controller
public class PageController {
    
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {		
		ModelAndView mv = new ModelAndView("page");		
		//mv.addObject("msg","Whatever you want");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title","Home");
		mv.addObject("userClickHome", true);
		return mv;				
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {		
		ModelAndView mv = new ModelAndView("page");		
		//mv.addObject("title","About");
		mv.addObject("userClickAbout", true);
		return mv;				
	}
	
	
	
}
