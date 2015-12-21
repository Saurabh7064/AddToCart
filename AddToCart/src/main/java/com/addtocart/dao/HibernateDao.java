package com.addtocart.dao;

import java.util.List;

import com.addtocart.dto.HibernateDTO;

public interface HibernateDao {
	
	public void saveHibernateDTO(HibernateDTO hibernateDTO);
    public List<HibernateDTO> listHibernateDTO();

}
