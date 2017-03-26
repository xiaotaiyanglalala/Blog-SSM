package com.open.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.open.blog.dao.AdminUserDao;
import com.open.blog.dao.RoleDao;
import com.open.blog.entity.AdminUser;
import com.open.blog.entity.Role;
import com.open.blog.service.RoleService;

@Repository(value = "RoleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Autowired
	AdminUserDao adminUserDao;
	
	@Override
	public List<Role> findRoleUser() {
		// TODO Auto-generated method stub
		List<Role> roles = roleDao.findRole();
		for(Role role : roles) {
			List<AdminUser> adminUsers = null;
			try {
				adminUsers = adminUserDao.findUserByRoleId(role.getRid());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			role.setUsers(adminUsers);
		}
		System.out.println(roles.get(0).getUsers().get(0).getUsername());
		return roles;
	}

	@Override
	public List<Role> findRole() {
		// TODO Auto-generated method stub
		return roleDao.findRole();
	}

}
