package net.kzn.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {		
		ModelAndView mv = new ModelAndView("page");		
		//mv.addObject("msg","Whatever you want");
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
