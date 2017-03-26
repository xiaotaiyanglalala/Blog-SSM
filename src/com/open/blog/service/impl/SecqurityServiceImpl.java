package com.open.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.open.blog.dao.SecqurityDao;
import com.open.blog.entity.Secqurity;
import com.open.blog.service.SecqurityService;

@Repository(value = "SecqurityService")
public class SecqurityServiceImpl implements SecqurityService {

	@Autowired
	SecqurityDao secqurityDao;
	
	@Override
	public List<Secqurity> findSecquirty() throws Exception {
		// TODO Auto-generated method stub
		return secqurityDao.findSecquirty();
	}

}
