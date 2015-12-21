package com.addtocart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.addtocart.dto.HibernateDTO;
import com.addtocart.service.HibernateService;

@Controller
public class HibernateController {

	@Autowired
	HibernateService hibernateService;
	
	@RequestMapping("/form")
	public String HelloHibernate(@ModelAttribute HibernateDTO hibernateDTO){
		
		return "HibernateForm";
	}
	
	@RequestMapping("/register")
	public ModelAndView saveHibernateDTO(@ModelAttribute HibernateDTO hibernateDTO){
		
		hibernateService.saveHibernateDTO(hibernateDTO);
		
		System.out.println("saved");
		return new ModelAndView("redirect:list");

	}
	
	@RequestMapping("list")
	public ModelAndView getList() {
		List<HibernateDTO> hibernateDTO = hibernateService.listHibernateDTO();
		return new ModelAndView("list","hibernateDTO",hibernateDTO);
	}
	
}
