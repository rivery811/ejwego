package com.wego.web.pxy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.springframework.stereotype.Component;


@Component
public class Proxy {
	public int parseInt(String param) {
		//Function<String, Integer> f = s -> Integer.parseInt(s);
		Function<String, Integer> f = Integer :: parseInt;
		return f. apply(param);
	}
	public String string (Object param) {
		//Function<String, Integer> f = s -> Integer.parseInt(s);
		Function<Object, String> f = String :: valueOf;
		return f.apply(param);
	}
	
	
	public boolean equals(String p1, String p2) {
		//Function<String, Integer> f = s -> Integer.parseInt(s);
		BiPredicate<String, String> b = String :: equals;
		return b.test(p1, p2);
	}
	public int random(int x,int y) {
		BiFunction<Integer, Integer, Integer> s = (t,u)->(int)(Math.random()*(u-t))+t;
		return s.apply(x,y);
	}
	public int[] array(int size) {
		Function<Integer, int[]> f = int[] :: new;
		return f.apply(size);
	}
	public String currentDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	public String currentTime() {
		return new SimpleDateFormat("yyyy-MM-dd-hh-mm:ss").format(new Date());
	}

	


}
