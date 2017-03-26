package com.open.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.open.blog.entity.AdminUser;
import com.open.blog.entity.Role;
import com.open.blog.service.AdminUserService;
import com.open.blog.service.RoleService;

@Controller
@RequestMapping(value = "/adminuser")
public class AdminUserController {

	@Resource(name = "AdminUserService")
	AdminUserService adminUserService;
	
	@Resource(name = "RoleService")
	RoleService roleService;
	
	@RequestMapping(value = "start", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> adminStart(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String state = "1";
		try {
			adminUserService.adminStateUpdate(state, Integer.parseInt(request.getParameter("id")));
			map.put("ok", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("ok", 0);
		}
		return map;
	}
	
	@RequestMapping(value = "stop", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> adminStop(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String state = "0";
		try {
			adminUserService.adminStateUpdate(state, Integer.parseInt(request.getParameter("id")));
			map.put("ok", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("ok", 0);
		}
		return map;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		ModelAndView andView = new ModelAndView();
		List<Role> roles = null;
		AdminUser adminUser = null;
		try {
			roles = roleService.findRole();
			adminUser = adminUserService.findAdminUserByUserId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		andView.setViewName("admin/admin-edit");
		andView.addObject("roles", roles);
		andView.addObject("adminUser", adminUser);
		return andView;
	}
	
	@RequestMapping(value = "toupdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> toUpdate(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		int id = Integer.valueOf(request.getParameter("id"));
		String adminName = request.getParameter("adminName");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int selectRole = Integer.valueOf(request.getParameter("selectRole"));
		AdminUser adminUser = null;
		try {
			if(!password.equals(password2)) {
				map.put("ok", 2);
				return map;
			}
			adminUser = adminUserService.findAdminUserByUsername(adminName);
			if(adminUser != null && adminUser.getUid() != id) {
				map.put("ok", 3);
				return map;
			}
			adminUser = new AdminUser();
			adminUser.setUid(id);
			adminUser.setUsername(adminName);
			adminUser.setPassword(password);
			adminUser.setPhone(phone);
			adminUser.setEmail(email);
			adminUser.setRid(selectRole);
			adminUserService.updateAdminUserById(adminUser);
			map.put("ok", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("ok", 4);
		}
		return map;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("admin/admin-add");
		List<Role> roles = null;
		try {
			roles = roleService.findRole();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		andView.addObject("roles", roles);
		return andView;
	}
	
	@RequestMapping(value = "toadd", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> toAdd(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String adminName = request.getParameter("adminName");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int selectRole = Integer.valueOf(request.getParameter("selectRole"));
		AdminUser adminUser = null;
		try {
			if(!password.equals(password2)) {
				map.put("ok", 2);
				return map;
			}
			adminUser = adminUserService.findAdminUserByUsername(adminName);
			if(adminUser != null) {
				map.put("ok", 3);
				return map;
			}
			adminUser = new AdminUser();
			adminUser.setUsername(adminName);
			adminUser.setPassword(password);
			adminUser.setPhone(phone);
			adminUser.setEmail(email);
			adminUser.setRid(selectRole);
			adminUser.setCrtime(System.currentTimeMillis() + "");
			adminUser.setState("1");
			adminUserService.addAdminUser(adminUser);
			map.put("ok", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("ok", 4);
		}
		return map;
	}
}
