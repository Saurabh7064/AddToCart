package com.addtocart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addtocart.dao.HibernateDao;
import com.addtocart.dto.HibernateDTO;
import com.addtocart.service.HibernateService;

@Service
public class HibernateServiceImpl implements HibernateService {

	@Autowired
	private HibernateDao hibernateDao;
	
	@Transactional
	public void saveHibernateDTO(HibernateDTO hibernateDTO) {
		hibernateDao.saveHibernateDTO(hibernateDTO);		
	}
	
	@Transactional(readOnly = true)
	public List<HibernateDTO> listHibernateDTO() {
		return hibernateDao.listHibernateDTO();
	}

}
