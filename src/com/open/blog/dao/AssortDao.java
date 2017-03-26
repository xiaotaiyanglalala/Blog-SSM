package com.open.blog.dao;

import java.util.List;

import com.open.blog.entity.Assort;

/**
 * 文章分类
 * @author Administrator
 *
 */
public interface AssortDao {

	public List<Assort> findAssortAll() throws Exception;
}
