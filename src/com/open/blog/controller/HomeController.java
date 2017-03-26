package com.open.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.open.blog.service.ArticleService;

@Controller
public class HomeController {

	@Resource(name = "ArticleService")
	ArticleService articleService;
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		int page = request.getParameter("page") == null ? 0 : Integer.valueOf(request.getParameter("page")) ;
		ModelAndView andView = new ModelAndView();
		andView.addObject("articles", articleService.findArticle(page*10, 10));
		andView.addObject("pages", page);
		andView.addObject("count", articleService.queryArticleCount());
		andView.setViewName("index");
		return andView;
	}
	
	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView andView = new ModelAndView("list");
		return andView;
	}
	
	@RequestMapping("show")
	public ModelAndView show(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		ModelAndView andView = new ModelAndView();
		andView.addObject("article", articleService.findArticleById(id));
		andView.setViewName("show");
		return andView;
	}
}
