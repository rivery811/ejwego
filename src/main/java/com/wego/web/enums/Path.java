package com.wego.web.enums;

public enum Path {
UPLOAD_PATH,CRAWLING_PATH;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case UPLOAD_PATH:
			result = "C:\\Users\\hamuseco\\git\\temwego11\\src\\main\\webapp\\resources\\upload\\";
			break;
			
			
		case CRAWLING_PATH:
			result = "https://store.naver.com/accommodations/detail?entry=plt&id=1285629759&tab=bookingReview&tabPage=1";
			break;
		default:
			break;
		}
		return result;
	}  

}
