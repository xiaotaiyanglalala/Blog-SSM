package com.open.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.open.blog.dao.AssortDao;
import com.open.blog.entity.Assort;
import com.open.blog.service.AssortService;

@Repository(value = "AssortService")
public class AssortServiceImpl implements AssortService {

	@Autowired
	AssortDao assortDao;
	
	@Override
	public List<Assort> findAssortAll() throws Exception {
		// TODO Auto-generated method stub
		return assortDao.findAssortAll();
	}

}
