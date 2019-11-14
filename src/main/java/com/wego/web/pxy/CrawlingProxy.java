package com.wego.web.pxy;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wego.web.enums.Path;
import com.wego.web.utl.Printer;
@Component("crawler") // 이름을 주네? 익스텐즈 프록시가 충돌나서?
public class CrawlingProxy extends Proxy{
	@Autowired Printer p;
	@Autowired Box<String> box;
	public Box<String> engine(Map<?,?> paramMap){
		p.accept("키값"+paramMap.get("site")+paramMap.get("srch"));
		String word = "스톤애견풀빌라";
		switch (word) {
		case "스톤애견풀빌라":
			//box.clear();
/*			for(int i = 1; i<=37; i++) {
				System.out.println(Path.CRAWLING_PATH.toString()+string(i));
				crawling(Path.CRAWLING_PATH.toString()+string(i));	
			}
			*/
			box = crawling(Path.CRAWLING_PATH.toString());	
			break;

	
		}
		
		return box; 
	}
	private Box<String> crawling(String url) {
		try {
			Document rawData = Jsoup.connect(url).timeout(10*1000).get();
			Elements comment = rawData.select("div[class=review_txt]");
			
			for(Element e : comment) {
				box.add(e.text()+"\n");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return box;
	}

	
/*	private void crawling(String url) {
	
		box.clear();
    	try {
			Connection.Response response = Jsoup.connect(url)
			.method(Connection.Method.GET)
			.execute();
			Document document = response.parse();
			String text = document.html();
			p.accept("크롤링한 텍스트 \n"+text);
			box.add(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/

}
