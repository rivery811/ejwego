package com.wego.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.pxy.Box;
import com.wego.web.pxy.CrawlingProxy;
import com.wego.web.pxy.PageProxy;
import com.wego.web.pxy.UserProxy;
import com.wego.web.usr.User;
import com.wego.web.usr.UserMapper;


@Service
public class TxService {
	@Autowired TxMapper mapper;
	//@Autowired HashMap<String, Object> map;
	@Autowired PageProxy proxy;
	@Autowired CrawlingProxy cralwer;
//	@Autowired List<String> txServicelist;
	@Autowired UserMapper userMapper;
	@Autowired UserProxy manager;
	@Autowired Box<String> box;
	
	@SuppressWarnings("unchecked")
	public Box<String> crawling(Map<?,?> paramMap){
		
		return cralwer.engine(paramMap);
	}
	
	@Transactional// 여기서 룹 돌리는거니까 트렌잭셔널 어기다 거는거 맞음 매퍼 ㄴㄴㄴ
	public int registerUsers(){
		manager.insertUsers();
	
		int userCount = userMapper.countUsers();
		return userCount ;

	}
}