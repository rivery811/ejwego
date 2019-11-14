package com.wego.web.admin;

import java.util.HashMap;

import org.springframework.stereotype.Repository;
@Repository
public interface AdminMapper {

	public void insertAdminEid(Admin param);
	public Admin selectAdminbyidpw(Admin param);
	public void createAdmin(HashMap<String, String> paramMap);
	public void createImg(HashMap<String, String> paramMap);
	public void drop(HashMap<String, String> paramMap);
}
