package wego;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class Test {

	public static void main(String[] args) {
		 String birthday = "";
	        int a = 1950,b = 2019;
	       BiFunction<Integer,Integer,Integer> f = (t,u)->(int)(Math.random()*(u-t))+t;
	       int year = f.apply(a, b);
	           int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	           
	           int iMinMonth = 1;
	           int iMaxMonth = 12;
	           
	           int iRandomMonth = (int)(Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
	           int iRandomDay = (int)(Math.random() * (maxDays[iRandomMonth-1] -2) + 1);
	           birthday= String.valueOf(year)+"년"+String.valueOf(iRandomMonth)+"월"+String.valueOf(iRandomDay)+"일";
	           System.out.println(birthday);
	           
	           int c = 1111,d = 9999;
	           BiFunction<Integer,Integer,Integer> f1 = (t,u)->(int)(Math.random()*(u-t))+t;
	           int pre = f1.apply(c,d);
	           int af= f1.apply(c,d);
	           String tel = "010-"+String.valueOf(pre)+"-"+String.valueOf(af);
	           System.out.println(tel);
	           
	           
	           
	  
	    		List<String> uids = Arrays.asList("01ikor","056tac","06jdh7","0dlrem","0qs5fw","0trane","0v4w3a","0wi326","0yr71f","10srly");
	    		Collections.shuffle(uids);
	    		String uid = uids.get(0);
	    		System.out.println(uid);
	 

	
	    		List<String> comments = Arrays.asList("좋아요","싫어요","그냥그래요","별로에요","대만족","친절함","편함","나쁘지 않아요","괜찮습니다","매우만족합니다");
	    		Collections.shuffle(comments);
	    		String comment = comments.get(0);
	    		System.out.println(comment);
	    		
	    		
	    	

	}

}
