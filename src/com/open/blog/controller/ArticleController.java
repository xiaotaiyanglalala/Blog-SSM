package com.open.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.open.blog.entity.Article;
import com.open.blog.entity.Assort;
import com.open.blog.service.ArticleService;
import com.open.blog.service.AssortService;

/**
 * 文章管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource(name = "ArticleService")
	ArticleService articleService;
	
	@Resource(name = "AssortService")
	AssortService assortService;
	
	@RequestMapping(value = "add")
	public ModelAndView add() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("admin/article-add");
		List<Assort> assorts = null;
		try {
			assorts = assortService.findAssortAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		andView.addObject("assorts", assorts);
		return andView;
	}
	
	@RequestMapping(value = "toadd", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> toAdd(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String articleTitle = request.getParameter("articletitle");
		String articleTitle2 = request.getParameter("articletitle2");
		int articleType = Integer.valueOf(request.getParameter("articletype")) ;
		String keywords = request.getParameter("keywords");
		String articleintroduce = request.getParameter("articleintroduce");
		String author = request.getParameter("author");
		String sources = request.getParameter("sources");
		String allowcomments = request.getParameter("allowcomments");
		String content = request.getParameter("content");
		Article article = new Article();
		article.setTitle(articleTitle);
		article.setAssortid(articleType);
		article.setCtime(String.valueOf(System.currentTimeMillis()));
		article.setContent(content);
		article.setUserid(1);
		article.setState("1");
		article.setLookNum(0);
		article.setIntroduce(articleintroduce);
		article.setSource(sources);
		article.setAuthor(author);
		article.setKeyword(keywords);
		article.setOmititle(articleTitle2);
		try {
			articleService.insertArticle(article);
			map.put("ok", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("ok", 2);
		}
		return map;
	}
	
	@RequestMapping(value = "look")
	public ModelAndView look(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		ModelAndView andView = new ModelAndView();
		andView.setViewName("admin/article-look");
		Article article = articleService.findArticleById(id);
		andView.addObject("article", article);
		return andView;
	}
	
	@RequestMapping(value = "fileupload", method = RequestMethod.POST)
	public ModelAndView fileupload(HttpServletRequest request) {
		String fileName = request.getParameter("filename");
		
		return null;
	}
	
	@RequestMapping(value = "edit")
	public ModelAndView edit(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ModelAndView andView = new ModelAndView();
		andView.setViewName("admin/article-edit");
		Article article = null;
		List<Assort> assorts = null;
		try {
			assorts = assortService.findAssortAll();
			article = articleService.findArticleById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		andView.addObject("article", article);
		andView.addObject("assorts", assorts);
		return andView;
	}
	
	@RequestMapping(value = "del")
	public @ResponseBody Map<String, Object> delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Map<String, Object> map = new HashMap<>();
		try {
			articleService.deleteArticle(id);
			map.put("ok", 1);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("ok", 2);
		}
		return map;
	}
	
	@RequestMapping(value = "toupdate")
	public @ResponseBody Map<String, Object> update(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		int id = Integer.parseInt(request.getParameter("id"));
		String articleTitle = request.getParameter("articletitle");
		String articleTitle2 = request.getParameter("articletitle2");
		int articleType = Integer.valueOf(request.getParameter("articletype")) ;
		String keywords = request.getParameter("keywords");
		String articleintroduce = request.getParameter("articleintroduce");
		String author = request.getParameter("author");
		String sources = request.getParameter("sources");
		String allowcomments = request.getParameter("allowcomments");
		String content = request.getParameter("content");
		Article article = new Article();
		article.setTitle(articleTitle);
		article.setAssortid(articleType);
		article.setCtime(String.valueOf(System.currentTimeMillis()));
		article.setContent(content);
		article.setUserid(1);
		article.setState("1");
		article.setLookNum(0);
		article.setIntroduce(articleintroduce);
		article.setSource(sources);
		article.setAuthor(author);
		article.setKeyword(keywords);
		article.setOmititle(articleTitle2);
		article.setId(id);
		try {
			articleService.updateArticle(article);
			map.put("ok", 1);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("ok", 2);
		}
		return map;
	}
}
