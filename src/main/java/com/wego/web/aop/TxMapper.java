package com.wego.web.aop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.community.Community;
import com.wego.web.usr.User;

@Repository
public interface TxMapper {
	@Insert("insert into user (uid,pwd,uname,birth,gender,tel,pettype) values (\n" + 
			"  #{uid}, #{pwd},#{uname},#{birth},#{gender},#{tel},#{pettype}) ")
	public void insertUser(User u);
	
	@Insert(" insert into community ( rating,img,uid, comments, msg, boardType, title, content) values(\n" + 
			"        #{rating},#{img},#{uid},#{comments},#{msg},#{boardType},#{title},#{content}\n" + 
			"    )")
	public void insertComm(Community c);
	
}
