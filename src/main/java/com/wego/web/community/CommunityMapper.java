package com.wego.web.community;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wego.web.brd.Article;
import com.wego.web.pxy.PageProxy;
@Repository
public interface CommunityMapper {

	public void insertAdminEid(Community param);
	public Community selectAdminbyidpw(Community param);
	public void createAdmin(HashMap<String, String> paramMap);
	public void createImg(HashMap<String, String> paramMap);
	public void drop(HashMap<String, String> paramMap);
	public void insertCommu(Community c);
	public void insertContent(Community c);
	public List<Community> selectpagination(PageProxy pager);
	public String countCommunity();
}
