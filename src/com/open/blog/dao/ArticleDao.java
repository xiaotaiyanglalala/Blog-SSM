package com.open.blog.dao;

import java.util.List;

import com.open.blog.entity.Article;

/**
 * 文章Dao
 * @author Administrator
 *
 */
public interface ArticleDao {

	List<Article> findArticle(int page, int count);
	
	Article findArticleById(int id);
	/**查询文章数量*/
	int queryArticleCount();
	/** 查询所有文章 */
	List<Article> findArticleAll() throws Exception;
	
	void insertArticle(Article article) throws Exception;
	
	void deleteArticle(int id) throws Exception;
	
	void updateArticle(Article article) throws Exception;
}
