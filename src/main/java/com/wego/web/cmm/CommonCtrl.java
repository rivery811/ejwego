package com.wego.web.cmm;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wego.web.admin.AdminMapper;
import com.wego.web.enums.SQL;
import com.wego.web.usr.UserMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonCtrl {
	@Autowired UserMapper userMapper;
	@Autowired AdminMapper adminMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonCtrl.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "index";
	}
	 @RequestMapping(value="/create/db", method = RequestMethod.GET)
	 public @ResponseBody Map<?,?> createwegodb(){ // @ResponseBody 이것만  SOAP방식이 됨 저 위에 레스트 컨트롤러 아닌거 확인하고 리퀘스트 매핑 리스판스 바디 해줄것
	    	HashMap<String,String> map = new HashMap<>();
	    	map.put("CREATE_DB", SQL.CREATE_DB.toString());
	    	Consumer<HashMap<String,String>> c = t-> userMapper.createDB(map);
	    	c.accept(map);
	    	map.clear();
	    	map.put("msg", "SUCCESS");
	    	return map;
	 
 }
	 @RequestMapping(value="/create/img", method = RequestMethod.GET)
		public @ResponseBody Map<?,?> createimg(){
			HashMap<String,String> paramMap = new HashMap<>();
	    	paramMap.put("CREATE_TABLE", SQL.CREATE_IMG.toString());
	    	Consumer<HashMap<String,String>> c = t-> adminMapper.createImg(paramMap);
	    	c.accept(paramMap);
	    	paramMap.clear();
	    	paramMap.put("msg", "SUCCESS");
	    	return paramMap;
		} 
	 
	
}