package com.open.blog.service;

import java.util.List;

import com.open.blog.entity.Article;

public interface ArticleService {

	List<Article> findArticle(int page, int count);
	
	Article findArticleById(int id);
	
	int queryArticleCount();
	
	public List<Article> findArticleAll() throws Exception;
	
	public void insertArticle(Article article) throws Exception;
	
	void deleteArticle(int id) throws Exception;
	
	void updateArticle(Article article) throws Exception;
}
