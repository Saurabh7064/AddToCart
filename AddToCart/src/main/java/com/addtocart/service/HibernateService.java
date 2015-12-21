package com.addtocart.service;

import java.util.List;

import com.addtocart.dto.HibernateDTO;

 
public interface HibernateService {
	
	public void saveHibernateDTO(HibernateDTO hibernateDTO);

	public List<HibernateDTO> listHibernateDTO();

}
