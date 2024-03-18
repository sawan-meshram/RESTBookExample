package com.api.book.controller.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	public final String UPLOAD_DIR = "/home/shatam-25/eclipse-workspace/RESTBookExample/src/main/resources/static/images";
	
	//this will give the dynamic path to resource folder on project
	public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath(); 
	
	
	public FileUploadHelper() throws IOException {
		
	}
	
	public boolean uploadFile(MultipartFile file) {
		boolean flag = false;
		
		try {
			
			//1st option to upload the file
//			InputStream is = file.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			
			
			//2nd option to upload the file
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), 
					StandardCopyOption.REPLACE_EXISTING);
			
			flag = true;

			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return flag;
	}
}
