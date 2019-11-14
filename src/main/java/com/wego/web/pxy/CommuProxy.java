package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wego.web.aop.TxMapper;
import com.wego.web.brd.Article;
import com.wego.web.community.Community;
import com.wego.web.community.CommunityMapper;


@Component
public class CommuProxy {
	@Autowired CommunityMapper communityMapper;
	@Autowired CrawlingProxy cpxy;
	@Autowired Box<String> box;
	@Autowired  Trunk<String> trunk;
	@Autowired TxMapper txMapper;
	  public String writerUID() {
          List<String> uids = Arrays.asList("01ikor","056tac","06jdh7","0dlrem","0qs5fw","0trane","0v4w3a","0wi326","0yr71f","10srly");
          Collections.shuffle(uids);
          String uid = uids.get(0);
          return uid;
      }
      public String comment() {
          List<String> comments = Arrays.asList("좋아요","싫어요","그냥그래요","별로에요","대만족","친절함","편함","나쁘지 않아요","괜찮습니다","매우만족합니다");
          Collections.shuffle(comments);
          String comment = comments.get(0);
          return comment;
      }
      public String content(Map<?,?> paramMap) {
          List<String> fCONTENT = cpxy.engine(paramMap).getList();
          System.out.println(fCONTENT);
          List<String> CONTENT = Arrays.asList("너무좋아요", "또오고 싶어요", "여기 살고 싶어요", "주변에 알리고 싶어요", "주변에 소개하고 싶어요", "다음에 다시 올게요!", "다음엔 또치도 데리고 올게요","다음엔 둘리도 데리고 올게요"
                  , "다음엔 꽁이도 데리고 올게요", "다음엔 콩이도 데리고 올게요", "다음엔 나래도 데리고 올게요", "다음엔 방울이도 데리고 올게요", "다음엔 고양이도 데리고 올게요", "다음엔 강아지도 데리고 올게요", "다음엔 구찌도 데리고 올게요");
             Collections.shuffle(fCONTENT);
             Collections.shuffle(CONTENT);
             String fullCONTENT = fCONTENT.get(0)+CONTENT.get(0);
          return fullCONTENT;
      }
   public String title() {
           List<String> titles = Arrays.asList("너무좋아요", "또오고 싶어요", "여기 살고 싶어요", "주변에 알리고 싶어요", "주변에 소개하고 싶어요", "다음에 다시 올게요!", "다음엔 또치도 데리고 올게요","다음엔 둘리도 데리고 올게요"
                   , "다음엔 꽁이도 데리고 올게요", "다음엔 콩이도 데리고 올게요", "다음엔 나래도 데리고 올게요", "다음엔 방울이도 데리고 올게요", "다음엔 고양이도 데리고 올게요", "다음엔 강아지도 데리고 올게요", "다음엔 구찌도 데리고 올게요");
           Collections.shuffle(titles);
           String title = titles.get(0);
           return title;
       }
   public String msg() {
           List<String> msgs = Arrays.asList("좋아용","별로에용","짱이에요","나이스","굿","존좋");
           Collections.shuffle(msgs);
           String msg = msgs.get(0);
           return msg;
       }
       public String rating() {
           List<String> ratings = Arrays.asList("1점","2점","3점","4점","5점");
           Collections.shuffle(ratings);
           String rating = ratings.get(0);
           return rating;
       }
       private String boardtype() {
           return "리뷰";
       }
       public String artseq() {
           return null;
       }
       public String makeImge() {
            return null;
       }
    
       public ArrayList<String> contents() {
    	   trunk.put(Arrays.asList("site","srch"), Arrays.asList("직접입력","스톤애견풀빌라"));
       
           ArrayList<String> t = cpxy.engine(trunk.get()).getList();
           System.out.println("프록시"+box);
           System.out.println("1번"+box.get(0));

           return t;
       }
       
 
	  

	   
	   public void insertContent(Map<?,?> paramMap) {
		   ArrayList<String> t = contents();
		   for(int i=0;i< 10;i++) {
	            Collections.shuffle(t);     
	            String fullCONTENT = box.get(0);
	            txMapper.insertComm(new Community(artseq(),makeImge(),writerUID(),comment(),msg(),rating(),boardtype(),title(),fullCONTENT));
	           //communityMapper.insertCommu(new Community(artseq(),makeImge(),writerUID(),comment(),msg(),rating(),boardtype(),title(),fullCONTENT));
	           
	       }
	   
	   }
	
}
