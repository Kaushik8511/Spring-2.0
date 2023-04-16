package com.example.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String UPLOAD_DIRECTORY = "D:\\Spring 2.0\\file-uploading\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile myFile) {
		boolean uploaded = false;
		
		try {
//			//reading the file
//			InputStream iStream = myFile.getInputStream();
//			byte data[] = new byte[iStream.available()];
//			iStream.read(data);
//			iStream.close();
//			
//			//write the file
//			FileOutputStream foStream = new FileOutputStream(UPLOAD_DIRECTORY + File.separator + myFile.getOriginalFilename());
//			System.out.println(UPLOAD_DIRECTORY + File.separator + myFile.getOriginalFilename());
//			foStream.write(data);
//			foStream.flush();
//			foStream.close();
			
			//Alternative
			//static path
//			String path = UPLOAD_DIRECTORY + File.separator + myFile.getOriginalFilename();
			//Dynamic path
			final String path = new ClassPathResource("/static/image/").getFile().getAbsolutePath();
			System.out.println(path + File.separator + myFile.getOriginalFilename());
			Files.copy(myFile.getInputStream(), Paths.get(path + File.separator + myFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			uploaded = true;
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return uploaded;
	}
	
}
