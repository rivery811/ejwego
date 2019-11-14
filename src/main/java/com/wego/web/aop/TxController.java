package com.wego.web.aop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IFunction;
import com.wego.web.enums.SQL;
import com.wego.web.pxy.Box;
import com.wego.web.pxy.CommuProxy;
import com.wego.web.pxy.CrawlingProxy;
import com.wego.web.pxy.Trunk;
import com.wego.web.usr.UserMapper;
import com.wego.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
//	System.out.println(text);
	@Autowired Printer p;
	@Autowired TxService txservice;
	@Autowired TxController txcontroller;
	@Autowired Trunk<String> trunk;
//	@Autowired HashMap<String,String> map;
	@Autowired UserMapper userMapper;
	@Autowired CrawlingProxy crawler;
	@Autowired CommuProxy cpxy;
	
	 @GetMapping("/crawling/{site}/{srch}")
	 public void crawl(@PathVariable String site, @PathVariable String srch) {
		 p.accept(site+", srch "+ srch);
		 HashMap<String,Object>txMap= new HashMap<>();
		 txMap.clear();
		 txMap.put("site", site);
		 txMap.put("srch",srch);
		 txservice.crawling(txMap);

	 } 
	 @GetMapping("/register/users")
	 public Map<?,?> registerUsers() {
		// HashMap<String,Object>map= new HashMap<>();
		 int UserCount = txservice.registerUsers();
		 trunk.put(Arrays.asList("userCount"),Arrays.asList(crawler.string(UserCount)));
		 return trunk.get();
		 
	 }
	 @GetMapping("/content")
	 public void content(Map<?,?> paramMap) {
		 cpxy.insertContent(paramMap);
		 
	 }
	 

	 
		@GetMapping("/truncate/user")
		public Map<?,?> truncate(){
			HashMap<String,String> paramMap = new HashMap<>();
	    	paramMap.put("TRUNCATE", SQL.TRUNCATE_USER.toString());
	    	Consumer<HashMap<String,String>> c = t-> userMapper.truncate(paramMap);
	    	c.accept(paramMap);
	    	paramMap.clear();
	    	paramMap.put("msg", "SUCCESS");
	    	return paramMap;
		}

	 
}