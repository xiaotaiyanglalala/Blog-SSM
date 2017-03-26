package com.open.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.open.blog.dao.ArticleDao;
import com.open.blog.entity.Article;
import com.open.blog.service.ArticleService;

@Repository(value = "ArticleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleDao articleDao;
	
	@Override
	public List<Article> findArticle(int page, int count) {
		// TODO Auto-generated method stub
		return articleDao.findArticle(page, count);
	}

	@Override
	public Article findArticleById(int id) {
		// TODO Auto-generated method stub
		return articleDao.findArticleById(id);
	}

	@Override
	public int queryArticleCount() {
		// TODO Auto-generated method stub
		return articleDao.queryArticleCount();
	}

	@Override
	public List<Article> findArticleAll() throws Exception {
		// TODO Auto-generated method stub
		return articleDao.findArticleAll();
	}

	@Override
	public void insertArticle(Article article) throws Exception {
		// TODO Auto-generated method stub
		articleDao.insertArticle(article);
	}

	@Override
	public void deleteArticle(int id) throws Exception {
		// TODO Auto-generated method stub
		articleDao.deleteArticle(id);
	}

	@Override
	public void updateArticle(Article article) throws Exception {
		// TODO Auto-generated method stub
		articleDao.updateArticle(article);
	}

}
