package com.wego.web.enums;

public enum SQL {
	CREATE_USER,CREATE_ADMIN,DROP_USER, CREATE_DB,CREATE_IMG,DROP_ADMIN,TRUNCATE_USER;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case CREATE_DB:
			result = "CREATE DATABASE WEGODB";
			break;
		case CREATE_USER:
			result = "CREATE TABLE MYSQL.USER"
					+ "(UID VARCHAR(10) PRIMARY KEY,"
					+ "PWD VARCHAR(10) NOT NULL, "
					+ "UNAME VARCHAR(20),  "
					+ "BIRTH VARCHAR(10,)  "
					+ "GENDER VARCHAR(10), "
					+ "TEL VARCHAR(10), "
					+ "PETTYPE VARCHAR(20))";
			break;
		case DROP_USER:
			result = "drop table mysql.user";
			break;
		case CREATE_ADMIN:
			result = "CREATE TABLE ADMIN"
					+ "(EID VARCHAR(30) PRIMARY KEY,"
					+ "PWD VARCHAR(30) NOT NULL, "
					+ "ANAME VARCHAR(30), "
					+ "ADDR VARCHAR(50), "
					+ "TEL VARCHAR(30),"
					+ "POS VARCHAR(30),"
					+ "DEP VARCHAR(30),"
					+ "PRIVILEGE VARCHAR(30))";
			break;
		case CREATE_IMG:
			result = "CREATE TABLE IMG"
					+ "(IMG VARCHAR(20) PRIMARY KEY)";
			break;
		case DROP_ADMIN:
			result = "DROP TABLE ADMIN";
			break;
		case TRUNCATE_USER:
			result = "TRUNCATE TABLE USER";
			break;
		default:
			break;
		}
		return result;
	}  

}
