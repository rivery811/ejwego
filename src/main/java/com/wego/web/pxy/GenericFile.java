package com.wego.web.pxy;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component @Data @Lazy
public class GenericFile<T> {
	private File file;
	
/*
	public File makeDir(String t, String u) {
		BiFunction<String, String, File> f = File::new;
		return f.apply(t,u);
		
	}
	public File makeFile(File t , String u) {
		BiFunction<File, String,File> f = File::new;
		return f.apply(t, u);
		
	}
*/
	public File makeFile(T t1, String t2) {
		HashMap<String, T> o = new HashMap<>();
		o.put("T", t1);
		
		if(o.get("T")instanceof String) {
			file = new File((String)o.get("T"),t2);
		}else if(o.get("T")instanceof File) {
			file = new File((File)o.get("T"),t2);
		}
		return file;
	}
	
/*	File uploadPath = new GenericFile<String>().makeFile(uploadFolder,getFolder());
	File saveFile = new GenericFile<File>.makeFile(uploadFoPath,"");
	
	뭔가 이상함 */
}
