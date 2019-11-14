package com.wego.web.brd;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wego.web.pxy.PageProxy;

@Repository
public interface ArticleMapper {
	public void insertArticle(Article param);
	public String countArticle();
	public List<Article> selectpagination(PageProxy pxy);
	public void updateArticle(Article param);
	public void deleteArticle(String artseq);
    public List<Article> selectpagination();
    
}