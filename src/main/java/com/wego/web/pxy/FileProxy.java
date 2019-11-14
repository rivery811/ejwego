package com.wego.web.pxy;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.wego.web.enums.Path;
@Component("fliemanager")
public class FileProxy extends Proxy {
	public void fileupload(MultipartFile[] uploadFile) {
		
        String uploadFolder = Path.UPLOAD_PATH.toString();
        File uploadPath = new File(uploadFolder,getFolder());
        if(uploadPath.exists() ==false) {
        	uploadPath.mkdirs();
        }
        for(MultipartFile f : uploadFile) {
            String fname = f.getOriginalFilename();
            String extension = fname.substring(fname.lastIndexOf(".")+1);
            fname = fname.substring(fname.lastIndexOf("\\")+1,fname.lastIndexOf("."));
            UUID uuid = UUID.randomUUID();
            fname = fname+"-"+uuid.toString()+"."+extension;
            File saveFile = new File(uploadPath,fname);
            try {
                f.transferTo(saveFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	public String getFolder() {
		
		
		return currentDate().replace("-", File.separator);
	}

	
	
}
