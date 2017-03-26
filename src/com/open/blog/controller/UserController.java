package com.open.blog.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.open.blog.config.Global;
import com.open.blog.entity.AdminUser;
import com.open.blog.entity.Article;
import com.open.blog.entity.Assort;
import com.open.blog.entity.Role;
import com.open.blog.entity.Secqurity;
import com.open.blog.entity.User;
import com.open.blog.service.AdminUserService;
import com.open.blog.service.ArticleService;
import com.open.blog.service.AssortService;
import com.open.blog.service.RoleService;
import com.open.blog.service.SecqurityService;

@Controller
@RequestMapping(value = "/admin")
public class UserController {

	@Resource(name = "ArticleService")
	ArticleService articleService;
	
	@Resource(name = "RoleService")
	RoleService roleService;
	
	@Resource(name = "SecqurityService")
	SecqurityService secqurityService;
	
	@Resource(name = "AdminUserService")
	AdminUserService adminUserService;
	
	@Resource(name = "AssortService")
	AssortService assortService;
	
	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView andView = new ModelAndView("admin/welcome");
		return andView;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView andView = new ModelAndView("admin/login", "command", new User());
		return andView;
	}
	
	@RequestMapping(value = "tologin", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> toLogin(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String username = request.getParameter("loginname");
		String password = request.getParameter("loginpwd");
		String loginyzm = request.getParameter("yzm");
		String kaptchaExpected = (String)request.getSession()
			    .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(StringUtils.isNullOrEmpty(username)) {
			map.put("ok", 9);
			return map;
		}
		if(StringUtils.isNullOrEmpty(password)) {
			map.put("ok", 8);
			return map;
		}
		if(StringUtils.isNullOrEmpty(loginyzm)) {
			map.put("ok", 10);
			return map;
		}
		if(!loginyzm.equalsIgnoreCase(kaptchaExpected)) {
			map.put("ok", 5);
			return map;
		}
		AdminUser adminUser = null;
		try {
			adminUser = adminUserService.findAdminUserByUsername(username);
			if(adminUser == null) {
				map.put("ok", 6);
				return map;
			}
			if(!adminUser.getState().equals("1")){
				map.put("ok", 2);
				return map;
			}
			if(adminUser.getPassword().equals(password)) {
				map.put("ok", 1);
				map.put("action", request.getContextPath() + "/admin/home");
				request.getSession().setAttribute(Global.USER_INFO, adminUser);
				return map;
			} else {
				map.put("ok", 3);
				return map;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("ok", 11);
		}
		
		return map;
	}
	
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public ModelAndView loginOut(HttpServletRequest request) {
		ModelAndView andView = new ModelAndView("admin/login");
		HttpSession session = request.getSession();
		session.removeAttribute(Global.USER_INFO);
		session.removeAttribute(Global.SECQURITIES);
		return andView;
	}
	
	@RequestMapping(value = "home")
	public ModelAndView home() {
		ModelAndView andView = new ModelAndView("admin/index");
		return andView;
	}
	
	@RequestMapping(value = "articlelist")
	public ModelAndView articlelist() {
		ModelAndView andView = new ModelAndView("admin/article-list");
		List<Article> articles = null;
		List<Assort> assorts = null;
		try {
			articles = articleService.findArticleAll();
			assorts = assortService.findAssortAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		andView.addObject("articles", articles);
		andView.addObject("assorts", assorts);
		return andView;
	}
	
	@RequestMapping(value = "adminrole")
	public ModelAndView adminRole() {
		ModelAndView andView = new ModelAndView("admin/admin-role");
		List<Role> roles = null;
		try {
			roles = roleService.findRoleUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		andView.addObject("roles", roles);
		return andView;
	}
	/**
	 * 用户权限
	 * @return
	 */
	@RequestMapping(value = "adminpermission")
	public ModelAndView adminPermission() {
		ModelAndView andView = new ModelAndView("admin/admin-permission");
		List<Secqurity> secqurities = null;
		try {
			secqurities = secqurityService.findSecquirty();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		andView.addObject("secqurities", secqurities);
		return andView;
	}
	
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping(value = "adminlist")
	public ModelAndView adminList() {
		ModelAndView andView = new ModelAndView("admin/admin-list");
		List<AdminUser> adminUsers = null;
		try {
			adminUsers = adminUserService.findAdminUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		andView.addObject("adminUsers", adminUsers);
		return andView;
	}
}
