package com.wego.web.community;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

//가람가람가람가람

	import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;

	import org.springframework.web.bind.annotation.RequestMapping;

	import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.wego.web.cmm.ISupplier;
import com.wego.web.enums.Path;

import com.wego.web.pxy.Box;
import com.wego.web.pxy.CommuProxy;
import com.wego.web.pxy.PageProxy;
import com.wego.web.pxy.Trunk;
import com.wego.web.utl.Printer;
import lombok.extern.log4j.Log4j;


	@RestController
	@RequestMapping("/comms")
	@Log4j
	public class CommunityCtrl {
		private static final Logger logger = LoggerFactory.getLogger(CommunityCtrl.class);
		@Autowired Community admin;
		@Autowired Printer printer;
		@Autowired CommunityMapper communityMapper;
		@Autowired Map<String, Object> map;
		@Autowired CommuProxy cpxy;
		@Autowired PageProxy pager;
		@Autowired Box<Community> box;
		@Autowired Trunk<Object> trunk;
		

		@GetMapping("/comm")
		public Map<?,?> comm(Map<?,?> paramMap1){
			HashMap<String,String> paramMap = new HashMap<>();
			cpxy.insertContent(paramMap1);
	    	paramMap.put("msg", "SUCCESS");
	    	return paramMap;
		}
		
		@GetMapping("/page/{pageNo}/size/{pageSize}")
		public HashMap<String,Object> list(@PathVariable String pageSize,@PathVariable String pageNo) {
			printer.accept("커뮤pageSize"+pageSize);
			printer.accept("pageNo"+pageNo);
			pager.setPageNum(Integer.parseInt(pageNo));
			pager.setPageSize(Integer.parseInt(pageSize));
			pager.paging();
			//box.clear();
			ISupplier<List<Community>> p = () -> communityMapper.selectpagination(pager);
			//printer.accept("해당 페이지 글 목록\n" + p.get());
			/*map.accept(Arrays.asList("articles","pages","pxy"), Arrays.asList(p.get(),Arrays.asList(1,2,3,4,5),pxy));*/
			trunk.put(Arrays.asList("articles","pager"), Arrays.asList(p.get(),pager));
			System.out.println("페이지"+pager.toString());
			System.out.println("커뮤 컨트"+communityMapper.selectpagination(pager));
			return trunk.get();
		}
		
		


		

}
