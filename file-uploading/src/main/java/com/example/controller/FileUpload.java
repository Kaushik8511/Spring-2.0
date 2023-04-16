package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.helper.FileUploadHelper;

@RestController
public class FileUpload {

	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	
	@GetMapping("/")
	public String hello() {
		return "Hello guys";
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		
		try {
			System.out.println("Origin name: " + file.getOriginalFilename());
			System.out.println("file name: " + file.getName());
			System.out.println("content type: " + file.getContentType());
			//returns 0 if empty
			System.out.println("size: "+ file.getSize());
			System.out.println("class: " + file.getClass());
		
		
			
			//validations
			if(file.isEmpty()) {
				return new ResponseEntity<String>("Please upload the file", HttpStatusCode.valueOf(404));
			}
			if(!file.getContentType().equals("image/jpeg")) {
				return new ResponseEntity<String>("Please upload image", HttpStatus.NOT_FOUND);
			}
			
			
			//file upload code
			if(fileUploadHelper.uploadFile(file)) {
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("bad request", HttpStatusCode.valueOf(400));
	}
	
}
