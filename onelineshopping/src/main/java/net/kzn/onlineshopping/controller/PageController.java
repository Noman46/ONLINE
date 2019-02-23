package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

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
	
	/*
	 * Method to display All products and based on category
	 * */
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {     
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title","All Products");
		mv.addObject("userClickViewProducts", true);
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {     
		ModelAndView mv = new ModelAndView("page");
		
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title",category.getName());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	
	
}
